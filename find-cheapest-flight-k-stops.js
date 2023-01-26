var findCheapestPrice = function(n, flights, src, dst, k) {
    let costs = new Array(n).fill(Number.MAX_SAFE_INTEGER);
    costs[src] = 0;
    let stops = k+1;

    while (stops > 0) {
        let tmp = [...costs];
        for (let info of flights) {
            let s = info[0], d = info[1], cost = info[2];
            // we have not gotten to source yet
            if (tmp[s] == Number.MAX_SAFE_INTEGER) continue;

            if (costs[s] + cost < tmp[d]) {
                tmp[d] = costs[s]+cost;
            }
        }
        
        costs = tmp;
        stops--;
    }

    return costs[dst] == Number.MAX_SAFE_INTEGER ? -1 : costs[dst];
};
