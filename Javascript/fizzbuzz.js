const fuzzbizz = (counter, arr, msg = '') => {
    
        if(counter === 0) 
            return msg;
    
        let val = checkElement(counter, arr)
    
        if(val)
            msg += counter + ': ' + val + "\n"
    
        return fuzzbizz(counter - 1, arr, msg)
    }
    
    const checkElement = (counter, arr, msg = '', index=0) => {

        if(index < arr.length) { 
            if(arr[index] != undefined) {
                if((counter % (index+1)) === 0) {
                    msg += arr[index]
                }
            } return checkElement(counter, arr, msg, index+1)
        } else {
            return msg
        }
    }

    const printEmVals = [undefined, undefined, 'fizz', undefined, 'buzz', undefined, undefined, 'wut']
    console.log(fuzzbizz(100, printEmVals))