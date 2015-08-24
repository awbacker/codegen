package com.scantrust.pojo;

import java.util.List;

public class Version {

    public Integer block_quantity;
    public List<Integer> block_densities;
    public Integer size_cell_in_pixels_QR;
    public Integer size_pattern_in_cells;

    public int density(int index) {
        if (block_densities != null && (block_densities.size() >= index)) {
            return block_densities.get(index);
        } else {
            return 0;
        }
    }

}
