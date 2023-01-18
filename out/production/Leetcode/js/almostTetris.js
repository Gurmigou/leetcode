figures = {
    1: [[0, 0]],
    2: [[0, 0], [1, 0], [2, 0]],
    3: [[0, 0], [0, 1], [1, 0], [1, 1]],
    4: [[0, 0], [0, -1], [0, -2], [1, -1]],
    5: [[0, 0], [1, 0], [2, 0], [1, 1]]
}

function canBuild(n, m, index, i, j, grid, fill) {
    for (let [x, y] of figures[index]) {
        if (i + y >= n || i + y < 0 || j + x >= m || j + x < 0 || grid[i + y][j + x] !== 0)
            return false;
    }
    for (let [x, y] of figures[index]) {
        grid[i + y][j + x] = fill;
    }
    return true;
}

function tryBuild(grid, figureIndex, index, n, m) {
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (grid[i][j] === 0) {
                if (canBuild(n, m, figureIndex, i, j, grid, index))
                    return
            }
        }
    }
}

function almostTetris(n, m, figures) {
    const grid = new Array(n);
    for (let i = 0; i < n; i++) {
        grid[i] = new Array(m).fill(0)
    }

    let index = 1
    for (let figureIndex of figures) {
        tryBuild(grid, figureIndex, index, n, m)
        index++
    }

    return grid
}

const figure = [4, 2, 1, 3]
const n = 4
const m = 4
const grid = almostTetris(n, m, figure)
console.log(grid)