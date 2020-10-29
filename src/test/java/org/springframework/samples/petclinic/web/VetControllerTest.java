package org.springframework.samples.petclinic.web;

import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    ClinicService clinicServiceMock;

    @InjectMocks
    VetController vetControllerMock;

    List<Vet> vetList = new ArrayList<>();

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("VetControllerTest");
        //given
        vetList.add(new Vet()); // add vet to vet list
        given(clinicServiceMock.findVets()).willReturn(vetList);

        mockMvc = MockMvcBuilders.standaloneSetup(vetControllerMock).build();
    }

    @Test
    void testControllerShowVetList() throws Exception {
        mockMvc.perform(get("/vets.html"))
                .andExpect(status().isOk()) // status OK
                .andExpect(model().attributeExists("vets")) // attribute is vets
                .andExpect(view().name("vets/vetList")); // check view name
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