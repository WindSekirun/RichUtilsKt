package pyxis.uzuki.live.richutilskt.demo.item

import pyxis.uzuki.live.richutilskt.demo.DemoKind

/**
 * RichUtilsKt
 * Class: DemoExecuteItem
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
data class DemoExecuteItem(val kind: DemoKind, val title: String, val message: String, val execute: () -> Unit, val kotlinSample: String, val javaSample: String)