extern crate rstest;
extern crate postgres;

use rstest::codegen;
use postgres::{Connection, SslMode};

#[allow(dead_code)]
fn main() {
    let bits = [ 10, 3, 3, 3, 3, 7, 10, 6 ];
    let args = [ 1.0, 4.0, 4.0, 6.0, 6.1, 20.0, 8.0, 7.0];
    println!("{}", codegen::message::generate(&args, &bits));
    call_db();
}


fn call_db() {
    let cstr = "postgres://scantrust:scantrust@localhost:5432/st_local";
    //let conn = try!(Connection::connect(cstr, &SslMode::None));
}