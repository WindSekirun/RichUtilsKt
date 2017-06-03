package pyxis.uzuki.live.richutilskt

/**
 * Created by pyxis on 2017. 6. 3..
 */

fun fill(value: Long, length: Int): String {
    return fill(value.toString(), length)
}

fun fill(value: String, length: Int): String {
    var str = value
    var zeroNum = length - str.length
    if (zeroNum > 0) {
        while (zeroNum-- != 0) {
            str = '0' + str
        }
    }
    return str
}