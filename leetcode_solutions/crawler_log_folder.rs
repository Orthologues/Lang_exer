impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        let mut steps: i32 = 0;
        for log in logs.iter() {
            if !log.eq(&"./") {
                steps = if !log.eq(&"../") { steps+1 } else { std::cmp::max(0, steps-1) };
            }
        }
        return steps;
    }
}