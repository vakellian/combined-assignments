let arr = [1, 2, 33, 4, 5]

console.log(arr.reduce(
    (previouslyReturned, currentElement) => {

        previouslyReturned.push(currentElement)

        for (let i = 0; i < previouslyReturned.length; i++) {

            for (let j = 0; j < previouslyReturned.length; j++) {

                if (previouslyReturned[j] < previouslyReturned[j + 1]) {
                    let temp = previouslyReturned[j];
                    previouslyReturned[j] = previouslyReturned[j + 1]
                    previouslyReturned[j + 1] = temp;
                }

            }

        }
        return previouslyReturned
    }, []
))


const smallToLarge = (previous, current) => {

    const recursiveSort = (i = 0) => {
        if (i === previous.length) {
            previous.push(current)
            return previous
        }

        else if (previous[i] > current) {
            previous.splice(i, 0, msg)
            return previous
        }
        return recursiveSort(i + 1)
    }
    return previous
}




