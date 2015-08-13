#![allow(dead_code)]

static ALLOWED_CHARS: &'static str = "0123456789ABCDEFGHIJKLMNOPQRSTUV";

fn main() {
    test_generation();
}

fn test_generation() {
   // let expected_value = "01IDH80G7";
    let bits = [ 10, 3, 3, 3, 3, 7, 10, 6 ];
    let args = [ 1.0, 4.0, 4.0, 6.0, 6.1, 20.0, 8.0, 7.0];
    
    println!("{}", generate_message_byvec(&args, &bits));
}

fn generate_message_byvec(values: &[f64], lengths: &[i32]) -> String {
    let chars: Vec<char> = ALLOWED_CHARS.chars().collect();
    let total_size = lengths.iter().fold(0, |s, x| s + x);
    let mut buffer: Vec<bool> = Vec::with_capacity(total_size as usize);
    
    // creates the bit-string using a vector of booleans (like a bitvector)
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
    
    // chunk the buffer into 5 and convert to an int, then grab that char        
    buffer.chunks(5)
        .map(|x| x.iter().fold(0u8, bool_sum))
        .map(|x| chars[x as usize])
        .collect()
}

fn bool_vec_to_string(buffer: &Vec<bool>) -> String {
    // utility for dumping a vector of booleans as a bit string, e.g. 
    // [false, false, true, false] = "0010"
    buffer.iter().cloned().map(|c| if c { '1' } else { '0' } ).collect::<String>()
}

fn bool_sum(sum: u8, b: &bool) -> u8 {
    (sum << 1) + (*b as u8)
}