package com.appmatch.msusuarios.model;

import java.util.List;
import java.util.UUID;

public class DictionaryGroupingDto {
    private String id;
    private String groupname;
    private List<DictionarySubgroupDto> subgroups;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<DictionarySubgroupDto> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(List<DictionarySubgroupDto> subgroups) {
        this.subgroups = subgroups;
    }

    public DictionaryGroupingDto(String id, String groupname, List<DictionarySubgroupDto> subgroups) {
        this.id = id;
        this.groupname = groupname;
        this.subgroups = subgroups;
    }
}
