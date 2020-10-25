package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;
    @Mock
    VetRepository vetRepository;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    ClinicServiceImpl clinicServiceMock;

    @BeforeEach
    void setUp() {
        System.out.println("ClinicServiceImplTest");
    }

    @Test
    void findPetTypes() {
        //given
        List<PetType> petTypeList = new ArrayList<>();
        petTypeList.add(new PetType());
        given(petRepository.findPetTypes()).willReturn(petTypeList);
        //when
        Collection<PetType> petTypesRet = clinicServiceMock.findPetTypes();
        //then
        assertNotNull(petTypesRet);
        assertEquals(petTypeList, petTypesRet);
    }
}