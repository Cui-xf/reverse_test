package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.DatePickerFormatter;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0087\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* renamed from: DateRangePickerTitle-hOD91z4, reason: not valid java name */
    public final void m2060DateRangePickerTitlehOD91z4(final int displayMode, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        final Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(-1412719908);
        ComposerKt.sourceInformation($composer3, "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(displayMode) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1412719908, $dirty, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:334)");
            }
            if (!DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2087getPickerjFl4v0())) {
                int $dirty2 = $dirty;
                if (DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2086getInputjFl4v0())) {
                    $composer3.startReplaceGroup(980466951);
                    ComposerKt.sourceInformation($composer3, "339@15607L47,339@15602L74");
                    Strings.Companion companion = Strings.INSTANCE;
                    TextKt.m2711Text4IGK_g(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_input_title), $composer3, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, $dirty2 & 112, 0, 131068);
                    $composer2 = $composer3;
                    $composer2.endReplaceGroup();
                } else {
                    $composer2 = $composer3;
                    $composer2.startReplaceGroup(329785445);
                    $composer2.endReplaceGroup();
                }
            } else {
                $composer3.startReplaceGroup(980462952);
                ComposerKt.sourceInformation($composer3, "337@15482L48,337@15477L75");
                Strings.Companion companion2 = Strings.INSTANCE;
                TextKt.m2711Text4IGK_g(Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_title), $composer3, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, $dirty & 112, 0, 131068);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    this.$tmp0_rcvr.m2060DateRangePickerTitlehOD91z4(displayMode, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: DateRangePickerHeadline-v84Udv0, reason: not valid java name */
    public final void m2059DateRangePickerHeadlinev84Udv0(final Long selectedStartDateMillis, final Long selectedEndDateMillis, final int displayMode, final DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Long l;
        Long l2;
        int i2;
        Modifier modifier2;
        DateRangePickerDefaults dateRangePickerDefaults;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1611069472);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)363@16696L47,364@16770L45,373@17203L30,374@17268L28,365@16824L534:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            l = selectedStartDateMillis;
        } else if (($changed & 6) == 0) {
            l = selectedStartDateMillis;
            $dirty |= $composer2.changed(l) ? 4 : 2;
        } else {
            l = selectedStartDateMillis;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            l2 = selectedEndDateMillis;
        } else if (($changed & 48) == 0) {
            l2 = selectedEndDateMillis;
            $dirty |= $composer2.changed(l2) ? 32 : 16;
        } else {
            l2 = selectedEndDateMillis;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            i2 = displayMode;
        } else if (($changed & 384) == 0) {
            i2 = displayMode;
            $dirty |= $composer2.changed(i2) ? 256 : 128;
        } else {
            i2 = displayMode;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= ($changed & 4096) == 0 ? $composer2.changed(dateFormatter) : $composer2.changedInstance(dateFormatter) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            dateRangePickerDefaults = this;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            dateRangePickerDefaults = this;
            $dirty |= $composer2.changed(dateRangePickerDefaults) ? 131072 : 65536;
        } else {
            dateRangePickerDefaults = this;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1611069472, $dirty2, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:362)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String startDateText = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_start_headline), $composer2, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String endDateText = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_range_picker_end_headline), $composer2, 0);
            Modifier modifier4 = modifier2;
            dateRangePickerDefaults.m2057DateRangePickerHeadline0YIUgSQ(l, l2, i2, dateFormatter, modifier4, startDateText, endDateText, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C373@17205L26:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(482821121, $changed2, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:373)");
                    }
                    TextKt.m2711Text4IGK_g(startDateText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C374@17270L24:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1522669758, $changed2, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:374)");
                    }
                    TextKt.m2711Text4IGK_g(endDateText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1983getLambda1$material3_release(), $composer2, ($dirty2 & 14) | 918552576 | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), ($dirty2 >> 15) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    this.$tmp0_rcvr.m2059DateRangePickerHeadlinev84Udv0(selectedStartDateMillis, selectedEndDateMillis, displayMode, dateFormatter, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DateRangePickerHeadline-0YIUgSQ, reason: not valid java name */
    public final void m2057DateRangePickerHeadline0YIUgSQ(Long selectedStartDateMillis, final Long selectedEndDateMillis, final int displayMode, final DatePickerFormatter dateFormatter, final Modifier modifier, final String startDateText, final String endDateText, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int $changed1) {
        Long l;
        String formatterEndDate;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)416@19379L15,452@20912L168,450@20838L748:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectedStartDateMillis) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selectedEndDateMillis) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & 4096) == 0 ? $composer2.changed(dateFormatter) : $composer2.changedInstance(dateFormatter) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(startDateText) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(endDateText) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 536870912 : 268435456;
        }
        if ((306783379 & $dirty) != 306783378 || ($changed1 & 1) != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820363420, $dirty, $changed1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:415)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale($composer2, 0);
            int $dirty2 = $dirty;
            String formatterStartDate = DatePickerFormatter.CC.formatDate$default(dateFormatter, selectedStartDateMillis, defaultLocale, false, 4, null);
            l = selectedStartDateMillis;
            String formatterEndDate2 = DatePickerFormatter.CC.formatDate$default(dateFormatter, selectedEndDateMillis, defaultLocale, false, 4, null);
            String verboseStartDateDescription = dateFormatter.formatDate(l, defaultLocale, true);
            $composer2.startReplaceGroup(1063152176);
            String verboseEndDateDescription = "";
            ComposerKt.sourceInformation($composer2, "");
            if (verboseStartDateDescription != null) {
                formatterEndDate = formatterEndDate2;
            } else if (DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2087getPickerjFl4v0())) {
                $composer2.startReplaceGroup(1063160130);
                ComposerKt.sourceInformation($composer2, "430@19972L51");
                Strings.Companion companion = Strings.INSTANCE;
                formatterEndDate = formatterEndDate2;
                verboseStartDateDescription = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_picker_no_selection_description), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                formatterEndDate = formatterEndDate2;
                if (DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2086getInputjFl4v0())) {
                    $composer2.startReplaceGroup(1063163101);
                    ComposerKt.sourceInformation($composer2, "431@20065L46");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    String strM2992getString2EP1pXo = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_no_input_description), $composer2, 0);
                    $composer2.endReplaceGroup();
                    verboseStartDateDescription = strM2992getString2EP1pXo;
                } else {
                    $composer2.startReplaceGroup(-1401609201);
                    $composer2.endReplaceGroup();
                    verboseStartDateDescription = "";
                }
            }
            $composer2.endReplaceGroup();
            String date = dateFormatter.formatDate(selectedEndDateMillis, defaultLocale, true);
            $composer2.startReplaceGroup(1063168270);
            ComposerKt.sourceInformation($composer2, "");
            if (date != null) {
                verboseEndDateDescription = date;
            } else if (DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2087getPickerjFl4v0())) {
                $composer2.startReplaceGroup(1063176162);
                ComposerKt.sourceInformation($composer2, "442@20473L51");
                Strings.Companion companion3 = Strings.INSTANCE;
                verboseEndDateDescription = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_picker_no_selection_description), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (DisplayMode.m2082equalsimpl0(displayMode, DisplayMode.INSTANCE.m2086getInputjFl4v0())) {
                $composer2.startReplaceGroup(1063179133);
                ComposerKt.sourceInformation($composer2, "443@20566L46");
                Strings.Companion companion4 = Strings.INSTANCE;
                verboseEndDateDescription = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_date_input_no_input_description), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1401112209);
                $composer2.endReplaceGroup();
            }
            $composer2.endReplaceGroup();
            final String startHeadlineDescription = startDateText + ": " + verboseStartDateDescription;
            final String endHeadlineDescription = endDateText + ": " + verboseEndDateDescription;
            ComposerKt.sourceInformationMarkerStart($composer2, 1063190327, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(startHeadlineDescription) | $composer2.changed(endHeadlineDescription);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        SemanticsPropertiesKt.m5974setLiveRegionhR3wRGc($this$clearAndSetSemantics, LiveRegionMode.INSTANCE.m5948getPolite0phEisY());
                        SemanticsPropertiesKt.setContentDescription($this$clearAndSetSemantics, startHeadlineDescription + ", " + endHeadlineDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) value$iv);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM557spacedBy0680j_4 = Arrangement.INSTANCE.m557spacedBy0680j_4(Dp.m6693constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM557spacedBy0680j_4, centerVertically, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierClearAndSetSemantics);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 303323611, "C464@21398L16:DateRangePicker.kt#uh7d8r");
            if (formatterStartDate != null) {
                $composer2.startReplaceGroup(303346581);
                ComposerKt.sourceInformation($composer2, "460@21280L31");
                TextKt.m2711Text4IGK_g(formatterStartDate, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(303414750);
                ComposerKt.sourceInformation($composer2, "462@21349L22");
                function2.invoke($composer2, Integer.valueOf(($dirty2 >> 21) & 14));
                $composer2.endReplaceGroup();
            }
            function23.invoke($composer2, Integer.valueOf(($dirty2 >> 27) & 14));
            if (formatterEndDate != null) {
                $composer2.startReplaceGroup(303539959);
                ComposerKt.sourceInformation($composer2, "466@21475L29");
                TextKt.m2711Text4IGK_g(formatterEndDate, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(303606144);
                ComposerKt.sourceInformation($composer2, "468@21542L20");
                function22.invoke($composer2, Integer.valueOf(($dirty2 >> 24) & 14));
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            l = selectedStartDateMillis;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Long l2 = l;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    this.$tmp7_rcvr.m2057DateRangePickerHeadline0YIUgSQ(l2, selectedEndDateMillis, displayMode, dateFormatter, modifier, startDateText, endDateText, function2, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }
}
