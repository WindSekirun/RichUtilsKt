@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.provider.ContactsContract

data class ContactItem(var name: String, var phoneNumber: String) {
    override fun toString(): String {
        return "ContractItem name -> $name phoneNumber -> $phoneNumber"
    }
}

/**
 * load contact data from device
 *
 * @return arrayList of ContactItem
 */
fun Context.getContactsList() : List<ContactItem> {
    val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
    val sortOrder = "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} COLLATE LOCALIZED ASC"
    val numberColumn = ContactsContract.CommonDataKinds.Phone.NUMBER
    val displayNameColumn = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME

    val cursor = this.contentResolver.query(uri, projection, "", emptyArray<String>(), sortOrder)
    val list = generateSequence { if (cursor.moveToNext()) cursor else null }
            .map { ContactItem(it.getString(it.getColumnIndex(numberColumn)), it.getString(cursor.getColumnIndex(displayNameColumn))) }
            .toList()

    cursor.close()

    return list
}


