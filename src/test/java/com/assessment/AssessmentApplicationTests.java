package com.assessment;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import com.assessment.response.RankingCarResponse;
import com.assessment.document.Car;
import com.assessment.request.CarRequest;
import com.assessment.service.CarsService;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssessmentApplicationTests {


	private Logger logger = LoggerFactory.getLogger( AssessmentApplicationTests.class);

	@Autowired
    CarsService carService;

	private Gson gson = new Gson();
	
    @Autowired
	private MockMvc mockMvc;

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
		
		mockMvc = MockMvcBuilders.standaloneSetup
					(new  CarRequest(
								"Ford Fiesta 1.4"," Fiesta 1.4","Ford",
									new Date(), 13.14, 15.15
							)
					).build();
	}
	
    @Test
    public void testRankinCarService() throws Exception {

		List<RankingCarResponse>colRankin= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRankin.size();a++  ){
			RankingCarResponse rankin= colRankin.get(a);
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
    public void testRankinCarCsHwaysService() throws Exception {

		List<RankingCarResponse>colRankin= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRankin.size();a++  ){
			RankingCarResponse rankin= colRankin.get(a);
			logger.info(":"+rankin.getName() +" previa cidade:"+rankin.getTotalKMCity() +" previa rodovia:"+rankin.getTotalKMHways());
			switch (a) {
				case 0: assertEquals(3.067484662576687, rankin.getTotalKMHways()); break;
				case 1: assertEquals(2.9940119760479043, rankin.getTotalKMHways());break;
				case 2: assertEquals(3.2051282051282053, rankin.getTotalKMHways());break;
				case 3: assertEquals(3.144654088050314, rankin.getTotalKMHways());break;
				case 4: assertEquals(3.225806451612903, rankin.getTotalKMHways());break;
				case 5: assertEquals(3.3112582781456954, rankin.getTotalKMHways());break;
				case 6: assertEquals(3.2894736842105265, rankin.getTotalKMHways());break;
				case 7: assertEquals(3.3003300330033003, rankin.getTotalKMHways());break;
				case 8: assertEquals(3.2894736842105265, rankin.getTotalKMHways());break;
				case 9: assertEquals(3.9682539682539684, rankin.getTotalKMHways());break;
				default: break;
			}
			
		}

    }

	@Test
    public void testRankinCarCsCityService() throws Exception {

		List<RankingCarResponse>colRankin= carService.rankingList(10.00, 10.00, 5.00); 
		for(int a=0 ;a< colRankin.size();a++  ){
			RankingCarResponse rankin= colRankin.get(a);
			logger.info(":"+rankin.getName() +" previa cidade:"+rankin.getTotalKMCity() +" previa rodovia:"+rankin.getTotalKMHways());
			switch (a) {
				case 0: assertEquals(3.4965034965034962, rankin.getTotalKMCity()); break;
				case 1: assertEquals(3.597122302158273, rankin.getTotalKMCity());break;
				case 2: assertEquals(3.3557046979865772, rankin.getTotalKMCity());break;
				case 3: assertEquals(3.5714285714285716, rankin.getTotalKMCity());break;
				case 4: assertEquals(3.597122302158273, rankin.getTotalKMCity());break;
				case 5: assertEquals(3.5211267605633805, rankin.getTotalKMCity());break;
				case 6: assertEquals(3.787878787878788, rankin.getTotalKMCity());break;
				case 7: assertEquals(3.8051750380517504, rankin.getTotalKMCity());break;
				case 8: assertEquals(3.90625, rankin.getTotalKMCity());break;
				case 9: assertEquals(6.17283950617284, rankin.getTotalKMCity());break;
				default: break;
			}
			
		}

    }

	@Test
	public void rankinController() throws Exception 
	{
		String jsonRequest = gson.toJson(
								new CarRequest(
									"Ford Fiesta 1.4","Fiesta 1.4","Ford", null, 10.14, 13.15
								)
							);
		logger.info(jsonRequest);
		mockMvc.perform(
		post("/raking/car/save?")
		.contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
		.andDo(print())
		.andExpect(status().isCreated());
	}

}
