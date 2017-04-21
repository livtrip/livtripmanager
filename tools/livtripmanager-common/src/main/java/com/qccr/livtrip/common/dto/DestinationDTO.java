package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/21 19:49 Exp $$
 */
public class DestinationDTO {

    private List<DestinationStateDTO> root;

    public List<DestinationStateDTO> getRoot() {
        return root;
    }

    public void setRoot(List<DestinationStateDTO> root) {
        this.root = root;
    }
}
