function cloudMicroservice(events, commands, endTimeStamp) {
    const map = new Map()
    for (let [eventId, startTime, interval] of events) {
        let arr = [];
        for (let i = startTime; i <= endTimeStamp; i += interval) {
            arr.push(i)
        }
        map[eventId] = arr
    }
    const subUnsubMap = new Map()
    for (let [type, timestamp, eventId] of commands) {
        if (!subUnsubMap[eventId]) {
            subUnsubMap[eventId] = []
        }
        subUnsubMap[eventId].push(parseInt(timestamp))
    }
    const result = []
    for (let key in subUnsubMap) {
        let value = subUnsubMap[key]
        let timestamps = map[key];
        if (timestamps.length === 0)
            continue

        let size = 0;
        let prev = null
        for (let i = 0; i < value.length; i++) {
            let border = value[i]
            // sub
            if (i % 2 === 0) {
                if (i + 1 === value.length) {
                    for (let num of timestamps) {
                        if (num >= border && num !== prev) {
                            prev = num
                            size += 1
                        }
                    }
                } else {
                    let borderNext = value[i + 1]
                    for (let num of timestamps) {
                        if (num >= border && num <= borderNext && num !== prev) {
                            prev = num
                            size += 1
                        }
                    }
                }
            }
        }
        result.push(`${key}:${size}`)
    }
    return result
}

const events = [[1,0,5], [2,7,3]]
const commands = [["subscribe", "0", "1"], ["unsubscribe", "15", "1"], ["subscribe", "4", "2"]]
const endTimeStamp = 20

const result = cloudMicroservice(events, commands, endTimeStamp)
console.log(result)