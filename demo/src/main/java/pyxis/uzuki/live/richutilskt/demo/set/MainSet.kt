package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.MainItem

/**
 * RichUtilsKt
 * Class: MainSet
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
fun Context.getMainData(): ArrayList<MainItem> {
    val list = arrayListOf<MainItem>()

    list.add(MainItem(CategoryItem.ALERT, "utils/RAlert.kt", "Alert", getString(R.string.alert_category_content), getAlertSet()))
    list.add(MainItem(CategoryItem.ASSETS, "utils/RAssets.kt", "Assets", getString(R.string.assets_category_content), getAssetsSet()))
    list.add(MainItem(CategoryItem.BITMAP, "utils/RBitmap.kt", "Bitmap", getString(R.string.bitmap_category_content), getBitmapSet()))
    list.add(MainItem(CategoryItem.CLIPBOARD, "utils/RClipboard.kt", "Clipboard", getString(R.string.clipboard_category_content), getClipboardSet()))
    list.add(MainItem(CategoryItem.CONTACT, "utils/RContactProvider.kt", "Contact", getString(R.string.contact_category_content), getContactSet()))
    list.add(MainItem(CategoryItem.DATE, "utils/RDate.kt", "Date", "", empty))
    list.add(MainItem(CategoryItem.DEVICEID, "utils/RDeviceId.kt", "DeviceId", "", empty))
    list.add(MainItem(CategoryItem.DIMEN, "utils/RDimen.kt", "Dimen", "", empty))
    list.add(MainItem(CategoryItem.DRAWABLE, "utils/RDrawable.kt", "Drawable", "", empty))
    list.add(MainItem(CategoryItem.FILE, "utils/RFile.kt", "File", "", empty))
    list.add(MainItem(CategoryItem.FONT, "utils/RFont.kt", "Font", "", empty))
    list.add(MainItem(CategoryItem.HINTSPINNER, "utils/RHintSpinner.kt", "Hint Spinner", "", empty))
    list.add(MainItem(CategoryItem.INFLATER, "utils/RInflater.kt", "Inflater", "", empty))
    list.add(MainItem(CategoryItem.INTENT, "utils/RIntent.kt", "Intent", "", empty))
    list.add(MainItem(CategoryItem.JSON, "utils/RJson.kt", "Json", "", empty))
    list.add(MainItem(CategoryItem.KEYBOARD, "utils/RKeyboard.kt", "Keyboard", "", empty))
    list.add(MainItem(CategoryItem.KEYHASH, "utils/RKeyHash.kt", "KeyHash", "", empty))
    list.add(MainItem(CategoryItem.NETWORK, "utils/RNetwork.kt", "Network", "", empty))
    list.add(MainItem(CategoryItem.PERMISSION, "utils/RPermission.kt", "Permission", "", empty))
    list.add(MainItem(CategoryItem.PROCESS, "utils/RProcess.kt", "Process", "", empty))
    list.add(MainItem(CategoryItem.REBOOT, "utils/RReboot.kt", "Reboot", "", empty))
    list.add(MainItem(CategoryItem.STATUSBAR, "utils/RStatusBar.kt", "Status Bar", "", empty))
    list.add(MainItem(CategoryItem.STREAM, "utils/RStream.kt", "Stream", "", empty))
    list.add(MainItem(CategoryItem.SYSTEMSERVICE, "utils/RSystemService.kt", "System Service", "", empty))
    list.add(MainItem(CategoryItem.TEXT, "utils/RText.kt", "Text", "", empty))
    list.add(MainItem(CategoryItem.THREAD, "utils/RThread.kt", "Thread", "", empty))
    list.add(MainItem(CategoryItem.THUMBNAIL, "utils/RThumbnail.kt", "Thumbnail", "", empty))
    list.add(MainItem(CategoryItem.UNREAD, "utils/RUnReadCount.kt", "UnRead Count", "", empty))
    list.add(MainItem(CategoryItem.VERSION, "utils/RVersion.kt", "Version", "", empty))
    list.add(MainItem(CategoryItem.VIBRATE, "utils/RVibrate.kt", "Vibrate", "", empty))
    list.add(MainItem(CategoryItem.VIEW, "utils/RView.kt", "View", "", empty))
    list.add(MainItem(CategoryItem.CENTERICON, "widget/CenteredIconButton.kt", "Thumbnail", "", empty))
    list.add(MainItem(CategoryItem.COMBINED, "widget/CombinedTextView.kt", "CombinedTextView", "", empty))
    list.add(MainItem(CategoryItem.HTMLTEXTVIEW, "widget/HTMLTextView.kt", "HTMLTextView", "", empty))
    list.add(MainItem(CategoryItem.CRASH, "", "CrashHandler", "", empty))
    list.add(MainItem(CategoryItem.INAPP, "module/iap/RInAppBilling.kt", "InAppBilling", "", empty))
    list.add(MainItem(CategoryItem.LOCATION, "service/RLocationService.kt", "Location Service", "", empty))

    return list
}

val empty = arrayListOf<ExecuteItem>()