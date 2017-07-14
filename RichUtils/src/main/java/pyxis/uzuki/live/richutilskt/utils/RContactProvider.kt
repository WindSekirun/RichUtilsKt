@file:JvmName("Utils")
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
 * it will check permission is granted automatically
 * @return arrayList of ContactItem
 */
fun Context.getContactsList() : ArrayList<ContactItem> {
    val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
    val selection = ""
    val selectionArgs = emptyArray<String>()
    val sortOrder = "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} COLLATE LOCALIZED ASC"

    val cursor = this.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)

    val list = ArrayList<ContactItem>(cursor.count)
    cursor.moveToFirst()

    while (!cursor.isAfterLast) {
        val contractPhone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
        val contractName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
        list.add(ContactItem(contractName, contractPhone))
        cursor.moveToNext()
    }

    cursor.close()
    return list
}

