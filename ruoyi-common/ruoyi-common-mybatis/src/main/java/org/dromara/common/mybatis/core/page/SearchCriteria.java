package org.dromara.common.mybatis.core.page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class SearchCriteria {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("params")
    private Map<String, Object> searchParams = new HashMap<>();


}
