package yang.springframework.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import yang.springframework.petclinic.model.Owner;

import java.util.HashSet;
import java.util.Set;

public class OwnerControllerTest {

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
//        owners.add(Owner.builder().id(1L).build());
//        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup()
                .build();
    }

    @Test
    void listOwners() throws Exception {

    }

    @Test
    void listOwnersByIndex() throws Exception {

    }

    @Test
    void findOwners() throws Exception {

    }

    @Test
    void showOwner() throws Exception {

    }
}
