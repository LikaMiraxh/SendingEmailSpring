package com.example.email;

import com.example.email.pojo.entity.Doctor;
import com.example.email.repository.DoctorRepository;
import com.example.email.service.DefaultDoctorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTests {

	@Autowired
	private DefaultDoctorService defaultDoctorService;

	@MockBean
	private DoctorRepository doctorRepository;


	@Test
	public void findAllDoctorsTest(){
		when(doctorRepository.findAll()).thenReturn(Stream.
				of(new Doctor("Diego", "diego@gmail.com"),
						new Doctor("Dustin","dustin@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, defaultDoctorService.findAll().size());
	}

	@Test
	public void findDoctorsByDnameTest(){
		when(doctorRepository.findDoctorsByDname("Dustin")).thenReturn(new Doctor("Dustin","dustin@gmail.com"));
		Doctor doctor = defaultDoctorService.findDoctorsByDname("Dustin");
		assertEquals("Dustin", doctor.getDname());
		assertEquals("dustin@gmail.com", doctor.getDemail());
	}

	@Test
	public void findDoctorByDidTest(){
		final Integer did = 1;
		final Doctor doctor = new Doctor(did,"Dexter","dexter@gmail.com");

		given(doctorRepository.findDoctorByDid(did)).willReturn(doctor);

		Doctor expected = defaultDoctorService.findDoctorById(did);
		assertEquals(expected, doctor);
	}

	@Test
	public void doctorShouldBeDeletedTest(){
		final Integer did = 3;

		defaultDoctorService.delete(did);
		defaultDoctorService.delete(did);

		verify(doctorRepository, times(2)).deleteById(did);

	}

}
