package retbrown.restprimenum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
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
    public void verifySmallNumberSieve() throws Exception {
                mockMvc.perform(get("/primes/10?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(10)))
                .andExpect(jsonPath("$.primes", hasSize(4)))
                .andExpect(jsonPath("$.primes", is(Arrays.asList(2, 3, 5, 7))));
    }

    @Test
    public void verifyVeryLargeNumberSieve() throws Exception {
        mockMvc.perform(get("/primes/100000?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(100000)))
                .andExpect(jsonPath("$.primes", hasSize(9592)));
    }

    @Test
    public void verifyPrimeNumberSieve() throws Exception {
        mockMvc.perform(get("/primes/6701?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(6701)))
                .andExpect(jsonPath("$.primes", hasSize(864)));
    }

    @Test
    public void verify1Sieve() throws Exception {
        mockMvc.perform(get("/primes/1?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyNegativeNumberSieve() throws Exception {
        mockMvc.perform(get("/primes/-1?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verify0Sieve() throws Exception {
        mockMvc.perform(get("/primes/0?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyAlphaCharacterSieve() throws Exception {
        mockMvc.perform(get("/primes/abc?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyInvalidCharacterSieve() throws Exception {
        mockMvc.perform(get("/primes/.?method=sieve")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyXmlNumberSieve() throws Exception {
        mockMvc.perform(get("/primes/10?method=sieve")
                .header("Accept", MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/xml"))
                .andExpect(content().xml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Primes><initial>10</initial><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></Primes>"));
    }

    @Test
    public void verifySmallNumberSimple() throws Exception {
        mockMvc.perform(get("/primes/10?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(10)))
                .andExpect(jsonPath("$.primes", hasSize(4)))
                .andExpect(jsonPath("$.primes", is(Arrays.asList(2, 3, 5, 7))));
    }

    @Test
    public void verifyVeryLargeNumberSimple() throws Exception {
        mockMvc.perform(get("/primes/100000?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(100000)))
                .andExpect(jsonPath("$.primes", hasSize(9592)));
    }

    @Test
    public void verifyPrimeNumberSimple() throws Exception {
        mockMvc.perform(get("/primes/6701?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.initial", is(6701)))
                .andExpect(jsonPath("$.primes", hasSize(864)));
    }

    @Test
    public void verify1Simple() throws Exception {
        mockMvc.perform(get("/primes/1?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyNegativeNumberSimple() throws Exception {
        mockMvc.perform(get("/primes/-1?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verify0Simple() throws Exception {
        mockMvc.perform(get("/primes/0?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    @Test
    public void verifyAlphaCharacterSimple() throws Exception {
        mockMvc.perform(get("/primes/abc?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyInvalidCharacterSimple() throws Exception {
        mockMvc.perform(get("/primes/.?method=simple")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void verifyXmlNumberSimple() throws Exception {
        mockMvc.perform(get("/primes/10?method=simple")
                .header("Accept", MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/xml"))
                .andExpect(content().xml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Primes><initial>10</initial><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></Primes>"));
    }

    @Test
    public void verifyXmlNumberDefault() throws Exception {
        mockMvc.perform(get("/primes/")
                .header("Accept", MediaType.APPLICATION_XML))
                .andExpect(status().isNotFound());
    }

    @Test
    public void verifySmallNumberDefault() throws Exception {
        mockMvc.perform(get("/primes/")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}