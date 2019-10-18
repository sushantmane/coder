use std::io;
use std::cmp::Ordering;
use rand::Rng; // trait
fn main() {
    println!("Welcome to guessing game!"); // println! -- macro
    let sec_num = rand::thread_rng().gen_range(1, 101);
    loop {
        println!("Please input your guess:");
        let mut guess = String::new();
        io::stdin().read_line(&mut guess)
            .expect("Failed to read user input");
        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid input!");
                continue;
            },
        };

        match guess.cmp(&sec_num) {
            Ordering::Less => println!("Your guess is too small!"), // arm
            Ordering::Greater => println!("Your guess is too large"),
            Ordering::Equal => {
                println!("Good job! You win!");
                break;
            },
        };
    }
}
