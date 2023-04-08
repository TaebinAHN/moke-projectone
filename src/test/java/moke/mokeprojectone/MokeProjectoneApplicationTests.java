package moke.mokeprojectone;

import lombok.extern.slf4j.Slf4j;
import moke.mokeprojectone.mapper.TimeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MokeProjectoneApplicationTests {

	@Autowired
	private TimeMapper timeMapper;

	@Test
	public void testGetTime(){
		log.info("timeMapper Class name : " + timeMapper.getClass().getName());
		log.info("timeMapper time : " + timeMapper.getTime());
	}

	@Test
	public void testGetTime2(){
		log.info("getTime2");
		log.info("getTime2: " + timeMapper.getTime2());
	}

}
