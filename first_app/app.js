let logger=require('./logger');
let calculator=require('./calculator');
let os=require('os');
logger.log('hello')
console.log(calculator.targetedAdd(100,200));
console.log(os.freemem());
console.log(os.arch())
