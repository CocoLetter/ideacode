package com.baosi.ssm.domain;

import java.util.List;

public class HonorResult {

    private boolean success;
    private List<Honor> honorList;
    private Honor honor;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Honor> getHonorList() {
        return honorList;
    }

    public void setHonorList(List<Honor> honorList) {
        this.honorList = honorList;
    }

    public Honor getHonor() {
        return honor;
    }

    public void setHonor(Honor honor) {
        this.honor = honor;
    }
}
