#! /home/jiawei/.cargo/bin/rustc

// run "./hash_map_demo.rs && ./hash_map_demo" at the terminal (1. Compilation 2. Run the compiled executable)

use std::collections::HashMap;

fn call(number: &str) -> &str {
    match number { // "match" in Ruyst is equivalent to "switch" in cpp/java
        "798-1364" => "We're sorry, the call is unavailable",
        "645-7689" => "Hello, this is Ferrari Pizza",
        _ => "Hi! Please repeat your name?" // "_" refers to any unmatched cases
    }
}

fn main() {
    let mut contacts = HashMap::new();
    contacts.insert("Daniel", "798-1364");
    contacts.insert("Ashley", "645-7689");
    contacts.insert("Katie", "222-0011");
    contacts.insert("Rasmus", "438-0183");

    match contacts.get(&"Daniel") { 
        // returns to "Some" when an Optional<T> value does not return to the implicit null type
        // Some() is like a callback function in javascript, however it uses pointer here
        Some(&number)  => println!("Calling Daniel: answer: {}", call(number)), // like formatted string in py 3.6+
        // if no matches are found
        _ => println!("Daniel's number is not matched at our DB")
    }

    // Takes a pointer reference and returns Option<&Value>
    match contacts.get(&"Ashley") { 
        // returns to "Some" when an Optional<T> value does not return to the implicit null type
        // Some() is like a callback function in javascript, however it uses pointer here
        Some(&number)  => println!("Calling Ashley: answer: {}", call(number)), // like formatted string in py 3.6+
        // if no matches are found
        _ => println!("Ashley's number is not matched at our DB")
    }

    contacts.remove(&"Ashley");
    // `HashMap::insert()` returns `None`
    // if the inserted value is new, `Some(value)` otherwise
    println!("Altering the value of key \"Daniel\"");
    contacts.insert(&"Daniel", "645-7689");

    for (contact, &number) in contacts.iter() {
        let reply = call(number); // passed by reference instead of value, which avoids new memory allocation
        println!("Calling {}: {}", contact, reply);
        let reply_mem_addr = format!("{:p}", reply);
        println!("Memory address of the reply string \"{}\": {}", reply, reply_mem_addr);
    }
}