extern crate rstest;

use rstest::codegen;

fn main() {
    let bits = [ 10, 3, 3, 3, 3, 7, 10, 6 ];
    let args = [ 1.0, 4.0, 4.0, 6.0, 6.1, 20.0, 8.0, 7.0];
    println!("{}", codegen::message::generate(&args, &bits));
}
