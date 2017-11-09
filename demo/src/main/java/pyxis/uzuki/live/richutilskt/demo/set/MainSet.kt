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

    list.add(MainItem(CategoryItem.ALERT, "utils/RAlert.kt", "Alert", getString(R.string.alert_category_content)))
    list.add(MainItem(CategoryItem.ASSETS, "utils/RAssets.kt", "Assets", getString(R.string.assets_category_content)))
    list.add(MainItem(CategoryItem.BITMAP, "utils/RBitmap.kt", "Bitmap", getString(R.string.bitmap_category_content)))
    list.add(MainItem(CategoryItem.CLIPBOARD, "utils/RClipboard.kt", "Clipboard", getString(R.string.clipboard_category_content)))
    list.add(MainItem(CategoryItem.CONTACT, "utils/RContactProvider.kt", "Contact", getString(R.string.contact_category_content)))
    list.add(MainItem(CategoryItem.DATE, "utils/RDate.kt", "Date", getString(R.string.date_category_content)))
    list.add(MainItem(CategoryItem.DEVICEID, "utils/RDeviceId.kt", "DeviceId", getString(R.string.deviceid_category_content)))
    list.add(MainItem(CategoryItem.DIMEN, "utils/RDimen.kt", "Dimen", getString(R.string.dimen_category_content)))
    list.add(MainItem(CategoryItem.DRAWABLE, "utils/RDrawable.kt", "Drawable", getString(R.string.drawable_category_content)))
    list.add(MainItem(CategoryItem.FILE, "utils/RFile.kt", "File", getString(R.string.file_category_content)))
    list.add(MainItem(CategoryItem.FONT, "utils/RFont.kt", "Font", getString(R.string.font_category_content)))
    list.add(MainItem(CategoryItem.HINTSPINNER, "utils/RHintSpinner.kt", "Hint Spinner", ""))
    list.add(MainItem(CategoryItem.INFLATER, "utils/RInflater.kt", "Inflater", "Inflate View"))
    list.add(MainItem(CategoryItem.INTENT, "utils/RIntent.kt", "Intent", ""))
    list.add(MainItem(CategoryItem.JSON, "utils/RJson.kt", "Json", "Extract objects from JSON"))
    list.add(MainItem(CategoryItem.KEYBOARD, "utils/RKeyboard.kt", "Keyboard", "Toggle / Close Keyboard"))
    list.add(MainItem(CategoryItem.KEYHASH, "utils/RKeyHash.kt", "KeyHash", "get KeyHash of Application"))
    list.add(MainItem(CategoryItem.NETWORK, "utils/RNetwork.kt", "Network", "get State of Connection of Network"))
    list.add(MainItem(CategoryItem.PERMISSION, "utils/RPermission.kt", "Permission", ""))
    list.add(MainItem(CategoryItem.PROCESS, "utils/RProcess.kt", "Process", ""))
    list.add(MainItem(CategoryItem.REBOOT, "utils/RReboot.kt", "Reboot", ""))
    list.add(MainItem(CategoryItem.STATUSBAR, "utils/RStatusBar.kt", "Status Bar", ""))
    list.add(MainItem(CategoryItem.STREAM, "utils/RStream.kt", "Stream", ""))
    list.add(MainItem(CategoryItem.SYSTEMSERVICE, "utils/RSystemService.kt", "System Service", ""))
    list.add(MainItem(CategoryItem.TEXT, "utils/RText.kt", "Text", ""))
    list.add(MainItem(CategoryItem.THREAD, "utils/RThread.kt", "Thread", ""))
    list.add(MainItem(CategoryItem.THUMBNAIL, "utils/RThumbnail.kt", "Thumbnail", ""))
    list.add(MainItem(CategoryItem.UNREAD, "utils/RUnReadCount.kt", "UnRead Count", ""))
    list.add(MainItem(CategoryItem.VERSION, "utils/RVersion.kt", "Version", ""))
    list.add(MainItem(CategoryItem.VIBRATE, "utils/RVibrate.kt", "Vibrate", ""))
    list.add(MainItem(CategoryItem.VIEW, "utils/RView.kt", "View", ""))
    list.add(MainItem(CategoryItem.CENTERICON, "widget/CenteredIconButton.kt", "Thumbnail", ""))
    list.add(MainItem(CategoryItem.COMBINED, "widget/CombinedTextView.kt", "CombinedTextView", ""))
    list.add(MainItem(CategoryItem.HTMLTEXTVIEW, "widget/HTMLTextView.kt", "HTMLTextView", ""))
    list.add(MainItem(CategoryItem.CRASH, "", "CrashHandler", ""))
    list.add(MainItem(CategoryItem.INAPP, "module/iap/RInAppBilling.kt", "InAppBilling", ""))
    list.add(MainItem(CategoryItem.LOCATION, "service/RLocationService.kt", "Location Service", ""))

    return list
}

fun Context.getItemList(categoryItem: CategoryItem) : ArrayList<ExecuteItem> {
    return when (categoryItem) {
        CategoryItem.ALERT -> getAlertSet()
        CategoryItem.ASSETS -> getAssetsSet()
        CategoryItem.BITMAP -> getBitmapSet()
        CategoryItem.CLIPBOARD -> getClipboardSet()
        CategoryItem.CONTACT -> getContactSet()
        CategoryItem.DATE -> getDateSet()
        CategoryItem.DEVICEID -> getDeviceIdSet()
        CategoryItem.DIMEN -> getDimenSet()
        CategoryItem.DRAWABLE -> getDrawableSet()
        CategoryItem.FILE -> getFileSet()
        CategoryItem.FONT -> getFontSet()
        CategoryItem.HINTSPINNER -> TODO()
        CategoryItem.INFLATER -> getInflateSet()
        CategoryItem.JSON -> getJSONSet()
        CategoryItem.KEYBOARD -> getKeyboardSet()
        CategoryItem.KEYHASH -> getKeyHashSet()
        CategoryItem.NETWORK -> getNetworkSet()
        CategoryItem.PERMISSION -> TODO()
        CategoryItem.PHOTO -> TODO()
        CategoryItem.PICKMEDIA -> TODO()
        CategoryItem.PREFERENCE -> TODO()
        CategoryItem.PROCESS -> TODO()
        CategoryItem.REBOOT -> TODO()
        CategoryItem.STATUSBAR -> TODO()
        CategoryItem.STREAM -> TODO()
        CategoryItem.SYSTEMSERVICE -> TODO()
        CategoryItem.TEXT -> TODO()
        CategoryItem.UNREAD -> TODO()
        CategoryItem.VERSION -> TODO()
        CategoryItem.THUMBNAIL -> TODO()
        CategoryItem.VIBRATE -> TODO()
        CategoryItem.VIEW -> TODO()
        CategoryItem.CENTERICON -> TODO()
        CategoryItem.COMBINED -> TODO()
        CategoryItem.HTMLTEXTVIEW -> TODO()
        CategoryItem.INTENT -> TODO()
        CategoryItem.THREAD -> TODO()
        CategoryItem.CRASH -> TODO()
        CategoryItem.INAPP -> TODO()
        CategoryItem.LOCATION -> TODO()
    }
}