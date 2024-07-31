package com.appmatch.msusuarios.model;

import java.util.List;
import java.util.UUID;

public class DictionarySubgroupDto {
    private String subgroupname;
    private List<DictionaryValueDto> values;

    public String getSubgroupname() {
        return subgroupname;
    }

    public void setSubgroupname(String subgroupname) {
        this.subgroupname = subgroupname;
    }

    public List<DictionaryValueDto> getValues() {
        return values;
    }

    public void setValues(List<DictionaryValueDto> values) {
        this.values = values;
    }

    public DictionarySubgroupDto(String subgroupname, List<DictionaryValueDto> values) {
        this.subgroupname = subgroupname;
        this.values = values;
    }
}
