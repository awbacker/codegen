extern crate rstest;

use rstest::codegen::message;

#[test]
fn gets_expected_result() {
    let bits = [ 10, 3, 3, 3, 3, 7, 10, 6 ];
	let args = [ 1.0, 4.0, 4.0, 6.0, 6.1, 20.0, 8.0, 7.0];
	assert_eq!("01IDH80G7", message::generate(&args, &bits));
} 