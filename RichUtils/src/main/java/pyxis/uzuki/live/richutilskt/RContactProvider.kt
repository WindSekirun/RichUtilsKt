package pyxis.uzuki.live.richutilskt

import android.Manifest
import android.content.Context
import android.provider.ContactsContract



/**
 * Created by winds on 2017-06-26.
 */

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
    val isGranted = RPermission.getInstance(this).checkPermission(arrayOf(Manifest.permission.READ_CONTACTS),
            callback = { resultCode: Int, _: ArrayList<String> ->
        when (resultCode) {
            RPermission.PERMISSION_GRANTED -> getContactsList()
        }
    })

    if (isGranted) {
        return getContacts(this)
    } else {
        return arrayListOf()
    }
}

private fun getContacts(context:Context) : ArrayList<ContactItem> {
    val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
    val selection = ""
    val selectionArgs = emptyArray<String>()
    val sortOrder = "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} COLLATE LOCALIZED ASC"

    val cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)

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

