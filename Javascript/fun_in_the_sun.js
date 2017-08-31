
const arr = []

const num = 10
arr.push(num)

const str = "sup"
arr.push(str)

const boolean = true
arr.push(boolean)

const func = (x, y) => {
    x + y
}
arr.push(func)

const object = {
    'key': 'value',
    'add': func
}

arr.push(object)

console.log(typeof(arr)+"\n")

for(let i = 0; i < arr.length; i++) {
    console.log(typeof(arr[i]))
}


const obj = {
    'name': 'bill',
    'age': 33
}

const constructPerson = (name, age) => {
    return {
        'name': name,
        'age': age
    }
}

console.log("\n\n") 

const printPerson = (...people) => {
    for(let i = 0; i < people.length; i++) {
        console.log(people[i])
    }
} 

const bill = constructPerson('bill', 33)
const oliver = constructPerson('oliver', 42)
const mary = constructPerson('mary', 57)

//console.log(bill.age)

const people = [bill, oliver, mary]

console.log(people)

console.log("\n")

printPerson(...people)

const printAverageAge = (...people) => {
    let total = 0;
    for(let i = 0; i < people.length; i++) {
        total += people[i].age
    }
    return total/people.length
}

console.log(printAverageAge(bill, oliver, mary))
console.log(printAverageAge(...people)) // another way

console.log("\n\n")

for(let i = 1; i <= 100; i++) {

    if(i % 3 === 0) // use triple equals
        console.log(i + ': fizz')
}

console.log("\n")

const fuzzbizz = (counter, msg = '') => {

    if(counter === 0) 
        return msg;

    let val = ''

    if(counter % 3 === 0)
        val += ': fizz'

    if(counter % 5 === 0)
        val += ': buzz'

    if(val)
        msg += counter + ': ' + val + "\n"

    return fuzzbizz(counter - 1, msg)
}

console.log(fuzzbizz(100))

