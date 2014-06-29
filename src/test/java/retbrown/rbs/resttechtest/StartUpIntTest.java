package retbrown.rbs.resttechtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartUp.class)
@WebAppConfiguration
public class StartUpIntTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void verifySmallNumber() throws Exception {
                mockMvc.perform(get("/primes/10")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(10)))
                .andExpect(jsonPath("$.primes", hasSize(4)))
                .andExpect(jsonPath("$.primes", is(Arrays.asList(2, 3, 5, 7))));
    }

    @Test
    public void verifyVeryLargeNumber() throws Exception {
        mockMvc.perform(get("/primes/100000")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(100000)))
                .andExpect(jsonPath("$.primes", hasSize(9592)));
    }

    @Test
    public void verifyPrimeNumber() throws Exception {
        mockMvc.perform(get("/primes/6701")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(6701)))
                .andExpect(jsonPath("$.primes", hasSize(864)));
    }

    @Test
    public void verify1() throws Exception {
        mockMvc.perform(get("/primes/1")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyNegativeNumber() throws Exception {
        mockMvc.perform(get("/primes/-1")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verify0() throws Exception {
        mockMvc.perform(get("/primes/0")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyAlphaCharacter() throws Exception {
        mockMvc.perform(get("/primes/abc")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyInvalidCharacter() throws Exception {
        mockMvc.perform(get("/primes/.")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyXmlNumber() throws Exception {
        mockMvc.perform(get("/primes/10")
                .header("Accept", MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/xml"))
                .andExpect(content().xml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Primes><initial>10</initial><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></Primes>"));
    }
}