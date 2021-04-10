package com.assessment;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import com.assessment.document.Car;
import com.assessment.response.RankingCarResponse;
import com.assessment.service.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssessmentApplicationTests {


	private Logger logger = LoggerFactory.getLogger( AssessmentApplicationTests.class);

	@Autowired
    CarsService carService;


	@Test
	void contextLoads() throws Exception
	{
		carService.deleteAll(); 
		//Dados site https://www.noticiasautomotivas.com.br/top-10-carros-populares-mais-economicos/
		carService.save(new Car("Ford Ka 1.0"," Ka 1.0","Ford", new Date(), 13.14, 15.15));
		carService.save(new Car("Fiat Mobi Drive","1.0 GSR","Fiat" ,new Date(), 14.00 , 15.90));
		carService.save(  new Car("Fiat Argo Drive 1.0","E63 AMG","Fiat", new Date(), 14.20, 15.10));
		carService.save(new Car("Peugeot 208 1.2","208 1.2","Peugeot", new Date(),13.90,15.50));
		carService.save(new Car("Renault Kwid","1.0","Renault", new Date(),14.90,15.60));
		carService.save(new Car( "Chevrolet Onix","1.0 Onix","Chevrolet", new Date(), 13.90, 16.70));
		carService.save( new Car("Fiat Uno 1.0","Uno 1.0","Fiat", new Date(), 13.20, 15.20));
		carService.save(new Car("Chevrolet Onix Turbo","1.0 Turbo","Chevrolet", new Date(), 8.10, 12.6));
		carService.save( new Car("Chevrolet Joy 1.0","Joy 1.0","Chevrolet", new Date(),12.80, 15.20));
        carService.save(new Car("Volkswagen up!","1.0 TSI","Volkswagen", new Date(), 14.30, 16.30));
	}
	
    @Test
    public void testRankingCarService()  throws Exception{

		List<RankingCarResponse>colRanking= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRanking.size();a++  ){
			RankingCarResponse rankin= colRanking.get(a);
			logger.info(":"+rankin.getName() +" previa cidade:"+rankin.getTotalKMCity() +" previa rodovia:"+rankin.getTotalKMHways());
			switch (a) {
				case 0: assertEquals("Volkswagen up!", rankin.getName()); break;
				case 1: assertEquals("Chevrolet Onix", rankin.getName());break;
				case 2: assertEquals("Renault Kwid", rankin.getName());break;
				case 3: assertEquals("Fiat Mobi Drive", rankin.getName());break;
				case 4: assertEquals("Peugeot 208 1.2", rankin.getName());break;
				case 5: assertEquals("Fiat Argo Drive 1.0", rankin.getName());break;
				case 6: assertEquals("Fiat Uno 1.0", rankin.getName());break;
				case 7: assertEquals("Ford Ka 1.0", rankin.getName());break;
				case 8: assertEquals("Chevrolet Joy 1.0", rankin.getName());break;
				case 9: assertEquals("Chevrolet Onix Turbo", rankin.getName());break;
				default: break;
			}
			
		}
	}

    @Test
    public void testRankingCarCsCityService() throws Exception {

		List<RankingCarResponse>colRanking= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRanking.size();a++  ){
			RankingCarResponse rankin= colRanking.get(a);
			logger.info(":"+rankin.getName() +" previa cidade:"+rankin.getTotalKMCity() +" previa rodovia:"+rankin.getTotalKMHways());
			switch (a) {
				case 0: assertEquals(715.0, rankin.getTotalKMCity()); break;
				case 1: assertEquals(695.0, rankin.getTotalKMCity());break;
				case 2: assertEquals(745.0, rankin.getTotalKMCity());break;
				case 3: assertEquals(700.0, rankin.getTotalKMCity());break;
				case 4: assertEquals(695.0, rankin.getTotalKMCity());break;
				case 5: assertEquals(710.0, rankin.getTotalKMCity());break;
				case 6: assertEquals(660.0, rankin.getTotalKMCity());break;
				case 7: assertEquals(657.0, rankin.getTotalKMCity());break;
				case 8: assertEquals(640.0, rankin.getTotalKMCity());break;
				case 9: assertEquals(405.0, rankin.getTotalKMCity());break;
				default: break;
			}
			
		}

    }

	@Test
    public void testRankingCarCsHwaysService() throws Exception {

		List<RankingCarResponse>colRanking= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRanking.size();a++  ){
			RankingCarResponse rankin= colRanking.get(a);
			logger.info(":"+rankin.getName() +" previa cidade:"+rankin.getTotalKMCity() +" previa rodovia:"+rankin.getTotalKMHways());
			switch (a) {
				case 0: assertEquals(815.0, rankin.getTotalKMHways()); break;
				case 1: assertEquals(835.0, rankin.getTotalKMHways());break;
				case 2: assertEquals(780.0, rankin.getTotalKMHways());break;
				case 3: assertEquals(795.0, rankin.getTotalKMHways());break;
				case 4: assertEquals(775.0, rankin.getTotalKMHways());break;
				case 5: assertEquals(755.0, rankin.getTotalKMHways());break;
				case 6: assertEquals(760.0, rankin.getTotalKMHways());break;
				case 7: assertEquals(757.5, rankin.getTotalKMHways());break;
				case 8: assertEquals(760.0, rankin.getTotalKMHways());break;
				case 9: assertEquals(630.0, rankin.getTotalKMHways());break;
				default: break;
			}
			
		}

    }


}
