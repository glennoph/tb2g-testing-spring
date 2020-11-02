package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
public class OwnerControllerTest {

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("OwnerControllerTest");
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build(); // build mockMvc before test
    }

    @Test
    public void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new")) // get url
                .andExpect(status().isOk()) // status ok?
                .andExpect(model().attributeExists("owner")) // attribute owner
                .andExpect(view().name(ownerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM)) // view name
        ;
    }
}