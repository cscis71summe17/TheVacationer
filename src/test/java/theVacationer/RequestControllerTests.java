/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package theVacationer;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void safetyInfoNoCountryFails() throws Exception {
        this.mockMvc.perform(get("/safetyinfo"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void geoDataFiveCountriesPresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.geodataList", hasSize(5)));

    }
    @Test
    public void geoDataItalyPresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Italy")));
    }
    @Test
    public void geoDataFrancePresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("France")));
    }
    @Test
    public void geoDataGermanyPresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Germany")));

    }
    @Test
    public void geoDataSpainPresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Spain")));

    }
    @Test
    public void geoDataUKPresent() throws Exception {
        this.mockMvc.perform(get("/geodata"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("United Kingdom")));

    }

    @Test
    public void safetyInfoItalyPresent() throws Exception {
        this.mockMvc.perform(get("/safetyinfo").param("country", "Italy"))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void safetyInfoGermanyPresent() throws Exception {
        this.mockMvc.perform(get("/safetyinfo").param("country", "Germany"))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void safetyInfoFrancePresent() throws Exception {
        this.mockMvc.perform(get("/safetyinfo").param("country", "France"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void gratuitiesApiExists() throws Exception {
        this.mockMvc.perform(get("/gratuities").param("country", "France"))
                .andDo(print()).andExpect(status().isOk());

    }

}
