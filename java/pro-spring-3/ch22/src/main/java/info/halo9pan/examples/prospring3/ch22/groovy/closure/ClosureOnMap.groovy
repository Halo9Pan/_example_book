/**
 * Created on Jan 16, 2012
 */
package info.halo9pan.examples.prospring3.ch22.groovy.closure

def map = ['a': 10, 'b': 50]

Closure square = {key, value -> map[key] = value * value}

map.each square

println map