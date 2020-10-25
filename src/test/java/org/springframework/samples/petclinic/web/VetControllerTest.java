package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    ClinicService clinicServiceMock;

    @InjectMocks
    VetController vetControllerMock;

    List<Vet> vetList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        System.out.println("VetControllerTest");
        //given
        vetList.add(new Vet()); // add vet to vet list
        given(clinicServiceMock.findVets()).willReturn(vetList);
    }

    @Test
    void showVetList() {
        //given
        Map<String, Object> model = new HashMap<>();

        //when
        String modelRet = vetControllerMock.showVetList(model);

        //then
        assertEquals("vets/vetList", modelRet);
    }

    @Test
    void showResourcesVetList() {
        //when
        Vets vets = vetControllerMock.showResourcesVetList();

        // then
        assertNotNull(vets);

    }
}