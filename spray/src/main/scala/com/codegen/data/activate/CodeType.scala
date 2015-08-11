package com.codegen.data.activate

import net.fwbrasil.activate.entity.Entity
import net.fwbrasil.activate.entity.id.UUID

trait CodeType extends Entity {
    var description: String
    var major_version: Short
    var minor_version: Short
    var block_quantity: Short
    var block_densities: String  // [0.x, 1.2 etc]
    var block_coords: String
    var size_qr: Short
    var size_cell_in_pixels_fp: Short
    var size_cell_in_pixels_qr: Short
    var size_buffer_in_cells: Short
    var size_pattern_in_Cells: Short
    var is_archives: Boolean
}


