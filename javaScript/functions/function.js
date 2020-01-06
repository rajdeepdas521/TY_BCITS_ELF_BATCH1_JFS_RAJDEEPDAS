function add(a,b){
    var c=a+b;
    return c;
}

var sum = add(10,20);
console.log('Sum is ',sum)


var n1=10;
var str='10';
if(n1===str){
    console.log('equal');
}else{
    console.log('Not equal');
}

var a=10;
console.log(typeof a);

console.log(typeof null);
console.log(typeof undefined)

var addM = (a,b) => a+b;
var s = addM(10,40);
console.log('Sum ',s)
console.log('--------------------------------------------------')

var sqr = a => a*a;
var n = sqr(20)
console.log(`Saqare is ${n}`);
console.log(`square of 10 is ${10*10}`)
