package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJî\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$Jî\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean expanded, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0 onIconClick;
        Composer $composer2 = $composer.startRestartGroup(1752693020);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)298@11657L314,298@11577L394:ExposedDropdownMenu.android.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            onIconClick = function0;
        } else {
            onIconClick = i2 != 0 ? new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752693020, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:293)");
            }
            IconButtonKt.IconButton(onIconClick, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                }
            }), false, null, ComposableLambdaKt.rememberComposableLambda(-689144648, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.3
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
                    float f;
                    ComposerKt.sourceInformation($composer3, "C299@11671L290:ExposedDropdownMenu.android.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-689144648, $changed2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.android.kt:299)");
                        }
                        ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if (expanded) {
                            f = 180.0f;
                        } else {
                            f = 360.0f;
                        }
                        IconKt.m1587Iconww6aTOc(arrowDropDown, "Trailing icon for exposed dropdown menu", RotateKt.rotate(companion, f), 0L, $composer3, 48, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.4
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
                    ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, onIconClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1565textFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long unfocusedIndicatorColor3;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long leadingIconColor3;
        long leadingIconColor4;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long trailingIconColor3;
        long trailingIconColor4;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        long unfocusedLabelColor4;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 969536191, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)357@14650L7,357@14681L7,358@14754L8,360@14824L6,361@14935L6,362@14999L6,364@15078L6,364@15119L4,366@15193L6,369@15393L8,370@15455L6,372@15529L6,373@15676L8,376@15805L6,378@15935L6,378@15976L4,379@16070L8,380@16135L6,382@16210L6,382@16251L4,383@16309L6,383@16344L6,384@16427L8,385@16485L6,386@16547L6,386@16582L6,387@16668L8:ExposedDropdownMenu.android.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        long disabledTextColor2 = (i & 2) != 0 ? Color.m4185copywmQWz5c(textColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(textColor2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(textColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(textColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(textColor2) : 0.0f) : disabledTextColor;
        if ((i & 4) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            backgroundColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f);
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1494getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedIndicatorColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            unfocusedIndicatorColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : 0.42f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            long unfocusedIndicatorColor4 = unfocusedIndicatorColor2;
            unfocusedIndicatorColor3 = unfocusedIndicatorColor4;
            disabledIndicatorColor2 = Color.m4185copywmQWz5c(unfocusedIndicatorColor4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(unfocusedIndicatorColor4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(unfocusedIndicatorColor4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(unfocusedIndicatorColor4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(unfocusedIndicatorColor4) : 0.0f);
        } else {
            unfocusedIndicatorColor3 = unfocusedIndicatorColor2;
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            long jM1493getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU3) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long leadingIconColor5 = leadingIconColor2;
            leadingIconColor4 = Color.m4185copywmQWz5c(leadingIconColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconColor5) : 0.0f);
            leadingIconColor3 = leadingIconColor5;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor3 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1493getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU4) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU4) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long jM1494getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedTrailingIconColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            long trailingIconColor5 = trailingIconColor2;
            trailingIconColor4 = Color.m4185copywmQWz5c(trailingIconColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(trailingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(trailingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(trailingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(trailingIconColor5) : 0.0f);
            trailingIconColor3 = trailingIconColor5;
        } else {
            trailingIconColor3 = trailingIconColor2;
            trailingIconColor4 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            long jM1494getPrimary0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU3) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU3) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long jM1493getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU5) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            long unfocusedLabelColor5 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.m4185copywmQWz5c(unfocusedLabelColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(unfocusedLabelColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(unfocusedLabelColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(unfocusedLabelColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(unfocusedLabelColor5) : 0.0f);
            unfocusedLabelColor3 = unfocusedLabelColor5;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            long jM1493getOnSurface0d7_KjU6 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            placeholderColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU6) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU6) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            long placeholderColor3 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m4185copywmQWz5c(placeholderColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(placeholderColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(placeholderColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(placeholderColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(placeholderColor3) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(969536191, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:389)");
        }
        long unfocusedIndicatorColor5 = unfocusedIndicatorColor3;
        long unfocusedIndicatorColor6 = errorIndicatorColor2;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor5, unfocusedIndicatorColor6, disabledIndicatorColor2, leadingIconColor3, leadingIconColor4, errorLeadingIconColor2, trailingIconColor3, focusedTrailingIconColor2, trailingIconColor4, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor3, unfocusedLabelColor4, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1564outlinedTextFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long unfocusedBorderColor3;
        long disabledBorderColor2;
        long leadingIconColor2;
        long leadingIconColor3;
        long leadingIconColor4;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long trailingIconColor3;
        long trailingIconColor4;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        long unfocusedLabelColor4;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 1841636861, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)460@20635L7,460@20666L7,461@20739L8,463@20845L6,464@20909L6,466@20985L6,466@21026L4,468@21097L6,468@21140L8,469@21235L8,470@21294L6,472@21368L6,473@21515L8,476@21644L6,478@21774L6,478@21815L4,479@21909L8,480@21974L6,482@22049L6,482@22090L4,483@22148L6,483@22183L6,484@22266L8,485@22324L6,486@22386L6,486@22421L6,487@22507L8:ExposedDropdownMenu.android.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        long disabledTextColor2 = (i & 2) != 0 ? Color.m4185copywmQWz5c(textColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(textColor2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(textColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(textColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(textColor2) : 0.0f) : disabledTextColor;
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m4222getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1494getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedBorderColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            unfocusedBorderColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            long unfocusedBorderColor4 = unfocusedBorderColor2;
            unfocusedBorderColor3 = unfocusedBorderColor4;
            disabledBorderColor2 = Color.m4185copywmQWz5c(unfocusedBorderColor4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(unfocusedBorderColor4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(unfocusedBorderColor4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(unfocusedBorderColor4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(unfocusedBorderColor4) : 0.0f);
        } else {
            unfocusedBorderColor3 = unfocusedBorderColor2;
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long leadingIconColor5 = leadingIconColor2;
            leadingIconColor4 = Color.m4185copywmQWz5c(leadingIconColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconColor5) : 0.0f);
            leadingIconColor3 = leadingIconColor5;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor3 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1493getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU3) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long jM1494getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedTrailingIconColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            long trailingIconColor5 = trailingIconColor2;
            trailingIconColor4 = Color.m4185copywmQWz5c(trailingIconColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(trailingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(trailingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(trailingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(trailingIconColor5) : 0.0f);
            trailingIconColor3 = trailingIconColor5;
        } else {
            trailingIconColor3 = trailingIconColor2;
            trailingIconColor4 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            long jM1494getPrimary0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1494getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m4185copywmQWz5c(jM1494getPrimary0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1494getPrimary0d7_KjU3) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1494getPrimary0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1494getPrimary0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1494getPrimary0d7_KjU3) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long jM1493getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU4) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU4) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            long unfocusedLabelColor5 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.m4185copywmQWz5c(unfocusedLabelColor5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(unfocusedLabelColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(unfocusedLabelColor5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(unfocusedLabelColor5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(unfocusedLabelColor5) : 0.0f);
            unfocusedLabelColor3 = unfocusedLabelColor5;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1488getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            long jM1493getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            placeholderColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU5) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            long placeholderColor3 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m4185copywmQWz5c(placeholderColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(placeholderColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(placeholderColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(placeholderColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(placeholderColor3) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1841636861, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:489)");
        }
        long unfocusedBorderColor5 = unfocusedBorderColor3;
        long unfocusedBorderColor6 = errorBorderColor2;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor5, unfocusedBorderColor6, disabledBorderColor2, leadingIconColor3, leadingIconColor4, errorLeadingIconColor2, trailingIconColor3, focusedTrailingIconColor2, trailingIconColor4, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor3, unfocusedLabelColor4, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
