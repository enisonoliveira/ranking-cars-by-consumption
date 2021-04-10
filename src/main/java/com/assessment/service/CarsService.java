package com.assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.assessment.dao.CarsRepository;
import com.assessment.document.Car;
import com.assessment.request.CarRequest;
import com.assessment.response.RankingCarResponse;
import com.assessment.serviceimpl.CarsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;

@Service
public class CarsService implements CarsServiceImpl
{
    Logger logger = LoggerFactory.getLogger( CarsService.class);

    @Autowired
    private CarsRepository carsRepository;

    public Car saveConverter(CarRequest request) throws Exception
    {
        return  save( new Car(  
                                request.getName(),
                                request.getModel(),
                                request.getBrand(),
                                request.getYear(),
                                request.getCsFuelCityKML(),
                                request.getCsFuelHighwaysKML()
                            )
                );
    }
    
    public Car save(Car car)  throws Exception   
    {
        logger.info("Init save operation save");
        if((findByName(car.getName())))
        {
            throw  new  DuplicateFormatFlagsException 
            (
                 ": Operação não permitida,"+
                "  veículo :"+ car.getName()+ "ja existente na base de dados!"
             );
        } else {
            if(car.getName().equals("") || car.getCsFuelCityKML()==0.0 || car.getCsFuelHighwaysKML()==0)
            {
                throw new   Exception(": Operação não permitida, dados imcompletos!");
            }
        }
        logger.info("Finish save Opertion successfully");
       return carsRepository.save(car);
    }

   @Async
    public List<RankingCarResponse> rankingList
        (
            double totalKMCity,
            double totalKMHways, double gasolPrice
        )   throws Exception
    {
        logger.info("Ranking all...");
        validateDataSearch(totalKMCity,totalKMHways,gasolPrice);
        ArrayList <RankingCarResponse> colRanking = new ArrayList<>();
        List<Car> colCar =findAll();
        int a=0;
        for(Car car : colCar){
            a++;
            colRanking.add
            ( new  RankingCarResponse
                ( String.valueOf(a)+"°", car.getName(), car.getBrand(), car.getYear(),car.getCsFuelCityKML()
                    ,car.getCsFuelHighwaysKML(), totalKMCity,totalKMHways,gasolPrice
                )
            );
        }
        logger.info("Cool! We are lucky the ranking was a success...");
        return colRanking;
    }

    public boolean validateDataSearch
        (
            double totalKMCity,
            double totalKMHways,
            double gasolPrice
        )   throws Exception
    {
        logger.info("Init validate paramter search report...");
        if(totalKMCity==0.0|| totalKMHways==0.0 || gasolPrice==0)
        {
            logger.error("wait! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, dados imcompletos!");
        }
        logger.info("OK! paramter is valid search report...");
        return true;
    }

    public List<Car> findAll() throws InterruptedException 
    {
        logger.info("List all...");
        return gasolRankingCar(carsRepository.findAll( sortByIdAsc()));
    }

    public void deleteAll ()
    {
        logger.warn("Delet All! Please don't use that function in production...");
        carsRepository.deleteAll();
    } 

    public boolean findByName( String name )
    {
        logger.info("Search name :"+name);
        Optional<Car> car= carsRepository.findByName(name);
        return car.isPresent();
    }

   
    public Sort sortByIdAsc() 
    {
        logger.info("Pre ordem...");
        ArrayList<Order> colOrder = new ArrayList<>();
        colOrder.add( Order.desc("cs_fuel_city_km_l"));
        colOrder.add( Order.desc("cs_fuel_highways_km_l"));
        return  Sort.by(colOrder);
    }

    public List<Car>gasolRankingCar( List<Car> colCar) throws InterruptedException
    {
        logger.info("Wait i'm that working this...");
        Car newCar=null;
		int size = colCar.size();
		double newCarCal=0.0;
        ArrayList<Car>colCarTemp = new ArrayList<>();
		for(int i = 0; i < size; i++){
            Thread.sleep(1000);
			for( int a=0;a< colCar.size();a++){
				Car car = colCar.get(a);
				double calc= car.getCsFuelCityKML()+ car.getCsFuelHighwaysKML();
				if(calc>newCarCal){
					newCar=car;
					newCarCal=calc;
				}
			}
			colCarTemp.add(newCar);
     		colCar.remove(newCar);
			newCarCal=0.0;
		}
        logger.info("OK! Finish working process...");
		return colCarTemp;
	}
    
}