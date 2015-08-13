// static ALLOWED_CHARS: &'static str = "0123456789ABCDEFGHIJKLMNOPQRSTUV";
//static ZEROS: &'static str = "00000000000000000000";
//let zeros = "00000000000000000000000";

fn main() {
    test_generation();
}

fn test_generation() {
   // let expected_value = "01IDH80G7";
    let bits = [ 10, 3, 3, 3, 3, 7, 10, 6 ];
    let args = [ 1.0, 4.0, 4.0, 6.0, 6.0, 20.0, 8.0, 7.0];
    
    generate_message(&bits, &args);
}

fn generate_message(bits: &[i32], args: &[f64]) {
    let bit_string = create_bit_string(args, bits);
    let bit_vec    = create_bit_string_vec(args, bits);
    println!("{}", bool_vec_to_string(&bit_vec));    
    println!("{}", bit_string);
    bool_vec_to_message(&bit_vec);
}

fn bool_vec_to_message(buffer: &Vec<bool>) {
    for chunk in buffer.chunks(5) {
        let value = chunk.iter().fold(0u8, bool_sum);
    }
}

fn bool_sum(sum: u8, b: &bool) -> u8 {
    (sum << 1) + (*b as u8)
}

fn create_bit_string_vec(values: &[f64], lengths: &[i32]) -> Vec<bool> {
    // creates the bit-string using a vector of booleans (like a bitvector)
    let total_size = lengths.iter().fold(0, |s, x| s + x);
    let mut buffer: Vec<bool> = Vec::with_capacity(total_size as usize);
    for (value, len) in values.iter().zip(lengths.iter()) {
        let val = format!("{:b}", *value as i32);  // converts to binary string
        let mut needed = len - val.len() as i32;
        while needed > 0 {
            buffer.push(false);
            needed -= 1; 
        }
        for c in val.chars() {
            buffer.push(c == '1');
        }
    }
    buffer
}

fn create_bit_string(values: &[f64], lengths: &[i32]) -> String {
    let mut buffer = String::with_capacity(256);
    for (value, len) in values.iter().zip(lengths.iter()) {
        let val = format!("{:b}", *value as i32);  // converts to binary string
        let mut needed = len - val.len() as i32;
        while needed > 0 {
            buffer.push('0');
            needed -= 1; 
        }
        buffer.push_str(&val[..]);
    }
    buffer
}

fn bool_vec_to_string(buffer: &Vec<bool>) -> String {
    buffer.iter().cloned().map(|c| if c { '1' } else { '0' } ).collect::<String>()
}
