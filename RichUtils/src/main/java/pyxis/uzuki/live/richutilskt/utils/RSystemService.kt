@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.print.PrintManager
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

/**
 * get AccessibilityManager
 */
inline val Context.accessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

/**
 * get AccountManager
 */
inline val Context.accountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

/**
 * get ActivityManager
 */
inline val Context.activityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

/**
 * get AlarmManager
 */
inline val Context.alarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager

/**
 * get AppWidgetManager
 */
inline val Context.appWidgetManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

/**
 * get AppOpsManager
 */
inline val Context.appOpsManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

/**
 * get AudioManager
 */
inline val Context.audioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

/**
 * get BatteryManager
 */
inline val Context.batteryManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

/**
 * get BluetoothManager
 */
inline val Context.bluetoothManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

/**
 * get CameraManager
 */
inline val Context.cameraManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

/**
 * get CaptioningManager
 */
inline val Context.captioningManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

/**
 * get ClipboardManager
 */
inline val Context.clipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

/**
 * get ConnectivityManager
 */
inline val Context.connectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * get ConsumerIrManager
 */
inline val Context.consumerIrManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

/**
 * get DevicePolicyManager
 */
inline val Context.devicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

/**
 * get DisplayManager
 */
inline val Context.displayManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

/**
 * get downloadManager
 */
inline val Context.downloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

/**
 * get DropBoxManager
 */
inline val Context.dropBoxManager
    get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

/**
 * get InputMethodManager
 */
inline val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

/**
 * get InputManager
 */
inline val Context.inputManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.INPUT_SERVICE) as InputManager

/**
 * get JobScheduler
 */
inline val Context.jobScheduler
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

/**
 * get KeyguardManager
 */
inline val Context.keyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

/**
 * get LauncherApps
 */
inline val Context.launcherApps
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

/**
 * get LayoutInflater
 */
inline val Context.layoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

/**
 * get LocationManager
 */
inline val Context.locationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

/**
 * get MediaProjectionManager
 */
inline val Context.mediaProjectionManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

/**
 * get MediaRouter
 */
inline val Context.mediaRouter
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

/**
 * get MediaSessionManager
 */
inline val Context.mediaSessionManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

/**
 * get NfcManager
 */
inline val Context.nfcManager
    get() = getSystemService(Context.NFC_SERVICE) as NfcManager

/**
 * get NotificationManager
 */
inline val Context.notificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

/**
 * get NsdManager
 */
inline val Context.nsdManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.NSD_SERVICE) as NsdManager

/**
 * get PowerManager
 */
inline val Context.powerManager
    get() = getSystemService(Context.POWER_SERVICE) as PowerManager

/**
 * get PrintManager
 */
inline val Context.printManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.PRINT_SERVICE) as PrintManager

/**
 * get RestrictionsManager
 */
inline val Context.restrictionsManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

/**
 * get SearchManager
 */
inline val Context.searchManager
    get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager

/**
 * get SensorManager
 */
inline val Context.sensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager

/**
 * get StorageManager
 */
inline val Context.storageManager
    get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager

/**
 * get TelecomManager
 */
inline val Context.telecomManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager

/**
 * get TelephonyManager
 */
inline val Context.telephonyManager
    get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

/**
 * get TextServicesManager
 */
inline val Context.textServicesManager
    get() = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

/**
 * get TvInputManager
 */
inline val Context.tvInputManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

/**
 * get UiModeManager
 */
inline val Context.uiModeManager
    get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

/**
 * get UsbManager
 */
inline val Context.usbManager
    get() = getSystemService(Context.USB_SERVICE) as UsbManager

/**
 * get UserManager
 */
inline val Context.userManager
    @SuppressLint("InlinedApi")
    get() = getSystemService(Context.USER_SERVICE) as UserManager

/**
 * get Vibrator
 */
inline val Context.vibrator
    get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

/**
 * get WallpaperManager
 */
inline val Context.wallpaperManager
    get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager

/**
 * get WifiP2pManager
 */
inline val Context.wifiP2pManager
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

/**
 * get WifiManager
 */
inline val Context.wifiManager
    get() = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

/**
 * get WindowManager
 */
inline val Context.windowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager