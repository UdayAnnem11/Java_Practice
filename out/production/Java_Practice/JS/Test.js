
// function isPrime(n) {
//     let count = 0;
//     for (let i = 2; i < n; i++) {
//         if (n % i === 0) {
//             count++;
//         }
//     }
//     return count === 0 ? true : false;
// }
// console.log(isPrime(23));

function primeNumbers(n) {
    let primes = [];
    for (let i = 2; i < n; i++) {
        let count = 0;
        for (let j = 2; j < i; j++) {
            if (i % j === 0) {
                count++;
            }
        }
        if (count === 0) {
            primes.push(i);
        }
    }

    return primes;

}
// console.log(primeNumbers(24));

// let e=0;
// let f=1;

// function fibi(n){
//     if(n===0){
//         return 0 ;
//     }
//     let c = e+f ;
//     e=f;
//     f=c;
//     console.log(c);
//     fibi(n-1);
// }

// console.log(fibi(8));


// let nums = [ 2, 7, 4, 0, 9, 5, 1, 3 ,4 , 1] ;
// nums.sort();
// console.log(nums);
// function Triplets(){
//     for(let i=0;i<nums.length-1;i++){
//         if(nums[i]===nums[i+1]){
//             return nums[i];
//         }
//     }
// }

// console.log(Triplets());

// function findAllZeroSumSubarrays(arr) {
//     const map = new Map(); // Map to store sum -> list of indices
//     const result = [];
//     let sum = 0;

//     for (let i = 0; i < arr.length; i++) {
//         sum += arr[i];

//         // If sum is 0, we found a subarray from 0 to i
//         if (sum === 0) {
//             result.push([0, i]);
//         }

//         // If sum was seen before, there exists at least one subarray
//         // if (map.has(sum)) {
//         //     let indexes = map.get(sum);
//         //     for (let startIdx of indexes) {
//         //         result.push([startIdx + 1, i]);
//         //     }
//         // }

//         // Insert this sum into the map
//         if (!map.has(sum)) {
//             map.set(sum, []);
//         }
//         map.get(sum).push(i);
//     }

//     // Print all found subarrays
//     for (let [start, end] of result) {
//         console.log(`Subarray found from index ${start} to ${end}:`, arr.slice(start, end + 1));
//     }

//     if (result.length === 0) {
//         console.log("No subarrays with 0 sum found.");
//     }
// }

// // Example usage
// const arr = [3, 4, -7, 3, 1, 3, 1, -4, -2, -2];
// findAllZeroSumSubarrays(arr);

let arr = [-20, -3, 5, 6, -2];
arr.sort((a,b)=>a-b);
function MaxProduct(){
    return Math.max(arr[arr.length-1]*arr[arr.length-2],arr[0]*arr[1]);
}
console.log(MaxProduct());



console.log("Before");

setTimeout(() => console.log("First"), 1000);
setTimeout(() => console.log("Second"), 500);
setTimeout(() => console.log("Third"), 0);

console.log("After");

