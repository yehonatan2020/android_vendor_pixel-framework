package com.google.android.settings.overlay;

import android.app.AppGlobals;
import android.app.admin.DevicePolicyManager;
import android.content.Context;

import com.android.settings.R;
import com.android.settings.accessibility.AccessibilityMetricsFeatureProvider;
import com.android.settings.accessibility.AccessibilitySearchFeatureProvider;
import com.android.settings.accounts.AccountFeatureProvider;
import com.android.settings.applications.ApplicationFeatureProvider;
import com.android.settings.aware.AwareFeatureProvider;
import com.android.settings.biometrics.face.FaceFeatureProvider;
import com.android.settings.bluetooth.BluetoothFeatureProvider;
import com.android.settings.dashboard.suggestions.SuggestionFeatureProvider;
import com.android.settings.fuelgauge.BatterySettingsFeatureProvider;
import com.android.settings.fuelgauge.BatteryStatusFeatureProvider;
import com.android.settings.fuelgauge.PowerUsageFeatureProvider;
import com.android.settings.gestures.AssistGestureFeatureProvider;
import com.android.settings.overlay.DockUpdaterFeatureProvider;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.overlay.SupportFeatureProvider;
import com.android.settings.overlay.SurveyFeatureProvider;
import com.android.settings.search.SearchFeatureProvider;
import com.android.settings.security.SecuritySettingsFeatureProvider;
import com.android.settings.wifi.WifiTrackerLibProvider;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.google.android.settings.accessibility.AccessibilityMetricsFeatureProviderGoogleImpl;
import com.google.android.settings.accessibility.AccessibilitySearchFeatureProviderGoogleImpl;
import com.google.android.settings.accounts.AccountFeatureProviderGoogleImpl;
import com.google.android.settings.applications.ApplicationFeatureProviderGoogleImpl;
import com.google.android.settings.aware.AwareFeatureProviderGoogleImpl;
import com.google.android.settings.biometrics.face.FaceFeatureProviderGoogleImpl;
import com.google.android.settings.bluetooth.BluetoothFeatureProviderGoogleImpl;
import com.google.android.settings.connecteddevice.dock.DockUpdaterFeatureProviderGoogleImpl;
import com.google.android.settings.core.instrumentation.SettingsGoogleMetricsFeatureProvider;
import com.google.android.settings.dashboard.suggestions.SuggestionFeatureProviderGoogleImpl;
import com.google.android.settings.experiments.PhenotypeProxy;
import com.google.android.settings.fuelgauge.BatterySettingsFeatureProviderGoogleImpl;
import com.google.android.settings.fuelgauge.BatteryStatusFeatureProviderGoogleImpl;
import com.google.android.settings.fuelgauge.PowerUsageFeatureProviderGoogleImpl;
import com.google.android.settings.gestures.assist.AssistGestureFeatureProviderGoogleImpl;
import com.google.android.settings.search.SearchFeatureProviderGoogleImpl;
import com.google.android.settings.security.SecuritySettingsFeatureProviderGoogleImpl;
import com.google.android.settings.support.SupportFeatureProviderImpl;
import com.google.android.settings.survey.SurveyFeatureProviderImpl;
import com.google.android.settings.wifi.WifiTrackerLibProviderGoogleImpl;

public class FeatureFactoryImpl extends com.android.settings.overlay.FeatureFactoryImpl
{
    private AccessibilityMetricsFeatureProvider mAccessibilityMetricsFeatureProvider;
    private AccessibilitySearchFeatureProvider mAccessibilitySearchFeatureProvider;
    private AccountFeatureProvider mAccountFeatureProvider;
    private ApplicationFeatureProvider mApplicationFeatureProvider;
    private AssistGestureFeatureProvider mAssistGestureFeatureProvider;
    private AwareFeatureProvider mAwareFeatureProvider;
    private BatterySettingsFeatureProvider mBatterySettingsFeatureProvider;
    private BatteryStatusFeatureProvider mBatteryStatusFeatureProvider;
    private BluetoothFeatureProvider mBluetoothFeatureProvider;
    private DockUpdaterFeatureProvider mDockUpdaterFeatureProvider;
    private FaceFeatureProvider mFaceFeatureProvider;
    private MetricsFeatureProvider mMetricsFeatureProvider;
    private PowerUsageFeatureProvider mPowerUsageProvider;
    private SearchFeatureProvider mSearchFeatureProvider;
    private SecuritySettingsFeatureProvider mSecuritySettingsFeatureProvider;
    private SuggestionFeatureProvider mSuggestionFeatureProvider;
    private SupportFeatureProvider mSupportProvider;
    private SurveyFeatureProvider mSurveyFeatureProvider;
    private WifiTrackerLibProvider mWifiTrackerLibProvider;

    public ApplicationFeatureProvider getApplicationFeatureProvider(Context applicationContext) {
        if (mApplicationFeatureProvider == null) {
            applicationContext = applicationContext.getApplicationContext();
            mApplicationFeatureProvider = (ApplicationFeatureProvider)new ApplicationFeatureProviderGoogleImpl(applicationContext, applicationContext.getPackageManager(), AppGlobals.getPackageManager(), (DevicePolicyManager)applicationContext.getSystemService("device_policy"));
        }
        return mApplicationFeatureProvider;
    }

    public MetricsFeatureProvider getMetricsFeatureProvider() {
        if (mMetricsFeatureProvider == null) {
            mMetricsFeatureProvider = (MetricsFeatureProvider)new SettingsGoogleMetricsFeatureProvider();
        }
        return mMetricsFeatureProvider;
    }

    public SupportFeatureProvider getSupportFeatureProvider(Context context) {
        if (mSupportProvider == null) {
            mSupportProvider = (SupportFeatureProvider)new SupportFeatureProviderImpl(context.getApplicationContext());
        }
        return mSupportProvider;
    }

    public BatteryStatusFeatureProvider getBatteryStatusFeatureProvider(Context context) {
        if (mBatteryStatusFeatureProvider == null) {
            mBatteryStatusFeatureProvider = (BatteryStatusFeatureProvider)new BatteryStatusFeatureProviderGoogleImpl(context.getApplicationContext());
        }
        return mBatteryStatusFeatureProvider;
    }

    public BatterySettingsFeatureProvider getBatterySettingsFeatureProvider(Context context) {
        if (mBatterySettingsFeatureProvider == null) {
            mBatterySettingsFeatureProvider = (BatterySettingsFeatureProvider)new BatterySettingsFeatureProviderGoogleImpl(context.getApplicationContext());
        }
        return mBatterySettingsFeatureProvider;
    }

    public PowerUsageFeatureProvider getPowerUsageFeatureProvider(Context context) {
        if (mPowerUsageProvider == null) {
            mPowerUsageProvider = (PowerUsageFeatureProvider)new PowerUsageFeatureProviderGoogleImpl(context.getApplicationContext());
        }
        return mPowerUsageProvider;
    }

    public DockUpdaterFeatureProvider getDockUpdaterFeatureProvider() {
        if (mDockUpdaterFeatureProvider == null) {
            mDockUpdaterFeatureProvider = (DockUpdaterFeatureProvider)new DockUpdaterFeatureProviderGoogleImpl();
        }
        return mDockUpdaterFeatureProvider;
    }

    public SearchFeatureProvider getSearchFeatureProvider() {
        if (mSearchFeatureProvider == null) {
            mSearchFeatureProvider = (SearchFeatureProvider)new SearchFeatureProviderGoogleImpl();
        }
        return mSearchFeatureProvider;
    }

    public SurveyFeatureProvider getSurveyFeatureProvider(Context context) {
        if (PhenotypeProxy.getBooleanFlagByPackageAndKey(context, context.getString(R.string.config_settingsintelligence_package_name), "HatsConfig__is_enabled", false)) {
            if (mSurveyFeatureProvider == null) {
                mSurveyFeatureProvider = (SurveyFeatureProvider)new SurveyFeatureProviderImpl(context);
            }
            return mSurveyFeatureProvider;
        }
        return null;
    }

    public SuggestionFeatureProvider getSuggestionFeatureProvider(Context context) {
        if (mSuggestionFeatureProvider == null) {
            mSuggestionFeatureProvider = (SuggestionFeatureProvider)new SuggestionFeatureProviderGoogleImpl(context.getApplicationContext());
        }
        return mSuggestionFeatureProvider;
    }

    public AssistGestureFeatureProvider getAssistGestureFeatureProvider() {
        if (mAssistGestureFeatureProvider == null) {
            mAssistGestureFeatureProvider = (AssistGestureFeatureProvider)new AssistGestureFeatureProviderGoogleImpl();
        }
        return mAssistGestureFeatureProvider;
    }

    public AccountFeatureProvider getAccountFeatureProvider() {
        if (mAccountFeatureProvider == null) {
            mAccountFeatureProvider = (AccountFeatureProvider)new AccountFeatureProviderGoogleImpl();
        }
        return mAccountFeatureProvider;
    }

    public AwareFeatureProvider getAwareFeatureProvider() {
        if (mAwareFeatureProvider == null) {
            mAwareFeatureProvider = (AwareFeatureProvider)new AwareFeatureProviderGoogleImpl();
        }
        return mAwareFeatureProvider;
    }

    public FaceFeatureProvider getFaceFeatureProvider() {
        if (mFaceFeatureProvider == null) {
            mFaceFeatureProvider = (FaceFeatureProvider)new FaceFeatureProviderGoogleImpl();
        }
        return mFaceFeatureProvider;
    }

    public WifiTrackerLibProvider getWifiTrackerLibProvider() {
        if (mWifiTrackerLibProvider == null) {
            mWifiTrackerLibProvider = (WifiTrackerLibProvider)new WifiTrackerLibProviderGoogleImpl();
        }
        return mWifiTrackerLibProvider;
    }

    public SecuritySettingsFeatureProvider getSecuritySettingsFeatureProvider() {
        if (mSecuritySettingsFeatureProvider == null) {
            mSecuritySettingsFeatureProvider = (SecuritySettingsFeatureProvider)new SecuritySettingsFeatureProviderGoogleImpl(FeatureFactory.getAppContext());
        }
        return mSecuritySettingsFeatureProvider;
    }

    public BluetoothFeatureProvider getBluetoothFeatureProvider() {
        if (mBluetoothFeatureProvider == null) {
            mBluetoothFeatureProvider = (BluetoothFeatureProvider)new BluetoothFeatureProviderGoogleImpl(FeatureFactory.getAppContext());
        }
        return mBluetoothFeatureProvider;
    }

    public AccessibilitySearchFeatureProvider getAccessibilitySearchFeatureProvider() {
        if (mAccessibilitySearchFeatureProvider == null) {
            mAccessibilitySearchFeatureProvider = (AccessibilitySearchFeatureProvider)new AccessibilitySearchFeatureProviderGoogleImpl();
        }
        return mAccessibilitySearchFeatureProvider;
    }

    public AccessibilityMetricsFeatureProvider getAccessibilityMetricsFeatureProvider() {
        if (mAccessibilityMetricsFeatureProvider == null) {
            mAccessibilityMetricsFeatureProvider = (AccessibilityMetricsFeatureProvider)new AccessibilityMetricsFeatureProviderGoogleImpl();
        }
        return mAccessibilityMetricsFeatureProvider;
    }
}
