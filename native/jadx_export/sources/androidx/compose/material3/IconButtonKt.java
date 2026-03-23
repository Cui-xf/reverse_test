package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IconButton.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ab\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001ab\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001aX\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001af\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001c\u001an\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010 \u001a|\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"FilledIconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconButton", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:113:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void IconButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.IconButtonColors r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconButtonKt.IconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.IconButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void IconToggleButton(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, IconToggleButtonColors colors, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        boolean z;
        IconToggleButtonColors colors2;
        MutableInteractionSource mutableInteractionSource;
        final boolean enabled2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        int $dirty;
        IconToggleButtonColors colors3;
        Function0 factory$iv$iv$iv;
        final MutableInteractionSource interactionSource3;
        final IconToggleButtonColors colors4;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(692561811);
        ComposerKt.sourceInformation($composer2, "C(IconToggleButton)P(!1,6,5,3!1,4)150@7170L24,159@7503L5,160@7553L32,168@7909L175,154@7297L1028:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            function12 = function1;
        } else if (($changed & 48) == 0) {
            function12 = function1;
            $dirty2 |= $composer2.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i4 = $composer2.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i4;
        } else {
            colors2 = colors;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource = interactionSource;
        } else if ((196608 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 131072 : 65536;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled2 = z;
            colors4 = colors2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                enabled2 = i3 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = IconButtonDefaults.INSTANCE.iconToggleButtonColors($composer2, 6);
                }
                if (i5 != 0) {
                    interactionSource2 = null;
                    modifier3 = modifier5;
                    $dirty = $dirty2;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier5;
                    interactionSource2 = mutableInteractionSource;
                    $dirty = $dirty2;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                colors3 = colors2;
                interactionSource2 = mutableInteractionSource;
                enabled2 = enabled;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(692561811, $dirty, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:153)");
            }
            Modifier modifierM230backgroundbw27NRU$default = BackgroundKt.m230backgroundbw27NRU$default(ClipKt.clip(SizeKt.m726size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), IconButtonTokens.INSTANCE.m3308getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), $composer2, 6)), colors3.containerColor$material3_release(enabled2, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 6) & 896)).getValue().m4197unboximpl(), null, 2, null);
            int iM5957getCheckboxo7Vup1c = Role.INSTANCE.m5957getCheckboxo7Vup1c();
            float arg0$iv = IconButtonTokens.INSTANCE.m3308getStateLayerSizeD9Ej5fM();
            float arg0$iv2 = Dp.m6693constructorimpl(arg0$iv / 2);
            IconToggleButtonColors colors5 = colors3;
            MutableInteractionSource interactionSource4 = interactionSource2;
            int $dirty3 = $dirty;
            Modifier modifier$iv = ToggleableKt.m944toggleableO2vRcR0(modifierM230backgroundbw27NRU$default, checked, interactionSource4, RippleKt.m2425rippleOrFallbackImplementation9IZ8Weo(false, arg0$iv2, 0L, $composer2, 54, 4), enabled2, Role.m5949boximpl(iM5957getCheckboxo7Vup1c), function12);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -131204793, "C175@8190L30,176@8235L84:IconButton.kt#uh7d8r");
            long contentColor = colors5.contentColor$material3_release(enabled2, checked, $composer2, (($dirty3 >> 9) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 6) & 896)).getValue().m4197unboximpl();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor)), function2, $composer2, ProvidedValue.$stable | (($dirty3 >> 15) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource4;
            colors4 = colors5;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.IconToggleButton.2
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

                public final void invoke(Composer composer, int i8) {
                    IconButtonKt.IconToggleButton(checked, function1, modifier4, enabled2, colors4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledIconButton(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, IconButtonColors colors, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconButtonColors colors2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier3;
        int $dirty;
        Shape shape3;
        IconButtonColors colors3;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        Composer $composer2;
        final IconButtonColors colors4;
        final Modifier modifier4;
        final boolean enabled4;
        final Shape shape4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(1594730011);
        ComposerKt.sourceInformation($composer3, "C(FilledIconButton)P(5,4,2,6!1,3)217@10330L11,218@10393L24,230@10821L320,222@10520L621:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i5 = $composer3.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource = interactionSource;
        } else if ((196608 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer3.changed(mutableInteractionSource) ? 131072 : 65536;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((599187 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            shape4 = shape2;
            $composer2 = $composer3;
            enabled4 = enabled2;
            colors4 = colors2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    shape2 = IconButtonDefaults.INSTANCE.getFilledShape($composer3, 6);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = IconButtonDefaults.INSTANCE.filledIconButtonColors($composer3, 6);
                }
                if (i6 != 0) {
                    interactionSource2 = null;
                    shape3 = shape2;
                    $dirty = $dirty2;
                    colors3 = colors2;
                    enabled3 = enabled2;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = enabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                modifier3 = modifier2;
                shape3 = shape2;
                interactionSource2 = mutableInteractionSource;
                $dirty = $dirty2;
                colors3 = colors2;
                enabled3 = enabled2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594730011, $dirty, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:222)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2564Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.m2147containerColorvNxB06k$material3_release(enabled3), colors3.m2148contentColorvNxB06k$material3_release(enabled3), 0.0f, 0.0f, null, interactionSource2, ComposableLambdaKt.rememberComposableLambda(-1560623888, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C231@10831L304:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1560623888, $changed2, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:231)");
                        }
                        Modifier modifier$iv = SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3272getContainerWidthD9Ej5fM(), FilledIconButtonTokens.INSTANCE.m3271getContainerHeightD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1882507244, "C239@11116L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty & 14) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 12) & 1879048192), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            modifier4 = modifier3;
            enabled4 = enabled3;
            shape4 = shape3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.3
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

                public final void invoke(Composer composer, int i7) {
                    IconButtonKt.FilledIconButton(function0, modifier4, enabled4, shape4, colors4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledTonalIconButton(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, IconButtonColors colors, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconButtonColors colors2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier3;
        int $dirty;
        Shape shape3;
        IconButtonColors colors3;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        Composer $composer2;
        final IconButtonColors colors4;
        final Modifier modifier4;
        final boolean enabled4;
        final Shape shape4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(-783937767);
        ComposerKt.sourceInformation($composer3, "C(FilledTonalIconButton)P(5,4,2,6!1,3)284@13478L11,285@13541L29,297@13974L330,289@13673L631:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i5 = $composer3.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource = interactionSource;
        } else if ((196608 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer3.changed(mutableInteractionSource) ? 131072 : 65536;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((599187 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            shape4 = shape2;
            $composer2 = $composer3;
            enabled4 = enabled2;
            colors4 = colors2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    shape2 = IconButtonDefaults.INSTANCE.getFilledShape($composer3, 6);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = IconButtonDefaults.INSTANCE.filledTonalIconButtonColors($composer3, 6);
                }
                if (i6 != 0) {
                    interactionSource2 = null;
                    shape3 = shape2;
                    $dirty = $dirty2;
                    colors3 = colors2;
                    enabled3 = enabled2;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = enabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                modifier3 = modifier2;
                shape3 = shape2;
                interactionSource2 = mutableInteractionSource;
                $dirty = $dirty2;
                colors3 = colors2;
                enabled3 = enabled2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-783937767, $dirty, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:289)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2564Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.m2147containerColorvNxB06k$material3_release(enabled3), colors3.m2148contentColorvNxB06k$material3_release(enabled3), 0.0f, 0.0f, null, interactionSource2, ComposableLambdaKt.rememberComposableLambda(-1772884636, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C298@13984L314:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1772884636, $changed2, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:298)");
                        }
                        Modifier modifier$iv = SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3288getContainerWidthD9Ej5fM(), FilledTonalIconButtonTokens.INSTANCE.m3287getContainerHeightD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -507423912, "C306@14279L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty & 14) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 12) & 1879048192), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            modifier4 = modifier3;
            enabled4 = enabled3;
            shape4 = shape3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.3
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

                public final void invoke(Composer composer, int i7) {
                    IconButtonKt.FilledTonalIconButton(function0, modifier4, enabled4, shape4, colors4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledIconToggleButton(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, IconToggleButtonColors colors, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconToggleButtonColors colors2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        IconToggleButtonColors colors3;
        MutableInteractionSource interactionSource2;
        final Shape shape4;
        final MutableInteractionSource interactionSource3;
        final IconToggleButtonColors colors4;
        final boolean enabled4;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1708189280);
        ComposerKt.sourceInformation($composer2, "C(FilledIconToggleButton)P(!1,6,5,3,7!1,4)349@16472L11,350@16541L30,360@16890L32,361@16960L30,363@17050L320,354@16674L696:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled4 = enabled2;
            shape4 = shape2;
            colors4 = colors2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = IconButtonDefaults.INSTANCE.getFilledShape($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = IconButtonDefaults.INSTANCE.filledIconToggleButtonColors($composer2, 6);
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = null;
                    modifier3 = modifier2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1708189280, $dirty, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:354)");
            }
            IconToggleButtonColors colors5 = colors3;
            Modifier modifier5 = modifier3;
            SurfaceKt.m2563Surfaced85dljk(checked, function1, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5957getCheckboxo7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.containerColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896)).getValue().m4197unboximpl(), colors3.contentColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896)).getValue().m4197unboximpl(), 0.0f, 0.0f, (BorderStroke) null, interactionSource2, ComposableLambdaKt.rememberComposableLambda(1235871670, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C364@17060L304:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1235871670, $changed2, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:364)");
                        }
                        Modifier modifier$iv = SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3272getContainerWidthD9Ej5fM(), FilledIconButtonTokens.INSTANCE.m3271getContainerHeightD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1295472936, "C372@17345L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | (57344 & $dirty), (($dirty >> 18) & 14) | 48, 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource3 = interactionSource2;
            colors4 = colors5;
            enabled4 = enabled3;
            modifier4 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.3
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

                public final void invoke(Composer composer, int i7) {
                    IconButtonKt.FilledIconToggleButton(checked, function1, modifier4, enabled4, shape4, colors4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledTonalIconToggleButton(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, IconToggleButtonColors colors, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconToggleButtonColors colors2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        IconToggleButtonColors colors3;
        MutableInteractionSource interactionSource2;
        final Shape shape4;
        final MutableInteractionSource interactionSource3;
        final IconToggleButtonColors colors4;
        final boolean enabled4;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1676089246);
        ComposerKt.sourceInformation($composer2, "C(FilledTonalIconToggleButton)P(!1,6,5,3,7!1,4)420@19894L11,421@19963L35,431@20317L32,432@20387L30,434@20477L330,425@20101L706:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled4 = enabled2;
            shape4 = shape2;
            colors4 = colors2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = IconButtonDefaults.INSTANCE.getFilledShape($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = IconButtonDefaults.INSTANCE.filledTonalIconToggleButtonColors($composer2, 6);
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = null;
                    modifier3 = modifier2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1676089246, $dirty, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:425)");
            }
            IconToggleButtonColors colors5 = colors3;
            Modifier modifier5 = modifier3;
            SurfaceKt.m2563Surfaced85dljk(checked, function1, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5957getCheckboxo7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.containerColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896)).getValue().m4197unboximpl(), colors3.contentColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896)).getValue().m4197unboximpl(), 0.0f, 0.0f, (BorderStroke) null, interactionSource2, ComposableLambdaKt.rememberComposableLambda(-58218680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C435@20487L314:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-58218680, $changed2, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:435)");
                        }
                        Modifier modifier$iv = SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3288getContainerWidthD9Ej5fM(), FilledTonalIconButtonTokens.INSTANCE.m3287getContainerHeightD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1171714300, "C443@20782L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | (57344 & $dirty), (($dirty >> 18) & 14) | 48, 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource3 = interactionSource2;
            colors4 = colors5;
            enabled4 = enabled3;
            modifier4 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.3
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

                public final void invoke(Composer composer, int i7) {
                    IconButtonKt.FilledTonalIconToggleButton(checked, function1, modifier4, enabled4, shape4, colors4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void OutlinedIconButton(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, IconButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconButtonColors colors2;
        BorderStroke border2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier3;
        int $dirty;
        Shape shape3;
        IconButtonColors colors3;
        BorderStroke border3;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        Composer $composer2;
        final IconButtonColors colors4;
        final boolean enabled4;
        final Shape shape4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        final Modifier modifier4;
        Composer $composer3 = $composer.startRestartGroup(-1746603025);
        ComposerKt.sourceInformation($composer3, "C(OutlinedIconButton)P(6,5,3,7,1!1,4)491@23280L13,492@23345L26,493@23420L33,506@23882L190,497@23556L516:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i5 = $composer3.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                border2 = border;
                int i6 = $composer3.changed(border2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                border2 = border;
            }
            $dirty2 |= i6;
        } else {
            border2 = border;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer3.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            enabled4 = enabled2;
            shape4 = shape2;
            colors4 = colors2;
            border4 = border2;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    shape2 = IconButtonDefaults.INSTANCE.getOutlinedShape($composer3, 6);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = IconButtonDefaults.INSTANCE.outlinedIconButtonColors($composer3, 6);
                }
                if ((i & 32) != 0) {
                    BorderStroke border5 = IconButtonDefaults.INSTANCE.outlinedIconButtonBorder(enabled2, $composer3, (($dirty2 >> 6) & 14) | 48);
                    $dirty2 &= -458753;
                    border2 = border5;
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    shape3 = shape2;
                    border3 = border2;
                    $dirty = $dirty2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    colors3 = colors2;
                    border3 = border2;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = enabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier2;
                    shape3 = shape2;
                    colors3 = colors2;
                    border3 = border2;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = enabled2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    colors3 = colors2;
                    border3 = border2;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = enabled2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1746603025, $dirty, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:497)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2564Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.m2147containerColorvNxB06k$material3_release(enabled3), colors3.m2148contentColorvNxB06k$material3_release(enabled3), 0.0f, 0.0f, border3, interactionSource2, ComposableLambdaKt.rememberComposableLambda(582332538, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C507@23892L174:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(582332538, $changed2, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:507)");
                        }
                        Modifier modifier$iv = SizeKt.m726size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3371getContainerSizeD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i9 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1854043468, "C511@24047L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty & 14) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 9) & 234881024) | (1879048192 & ($dirty << 9)), 6, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            enabled4 = enabled3;
            shape4 = shape3;
            border4 = border3;
            interactionSource3 = interactionSource2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.3
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

                public final void invoke(Composer composer, int i8) {
                    IconButtonKt.OutlinedIconButton(function0, modifier4, enabled4, shape4, colors4, border4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void OutlinedIconToggleButton(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, IconToggleButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        IconToggleButtonColors colors2;
        BorderStroke border2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Modifier modifier3;
        boolean enabled3;
        IconToggleButtonColors colors3;
        MutableInteractionSource interactionSource2;
        Shape shape3;
        BorderStroke border3;
        final Shape shape4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        final IconToggleButtonColors colors4;
        final boolean enabled4;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1470292106);
        ComposerKt.sourceInformation($composer2, "C(OutlinedIconToggleButton)P(1,7,6,4,8,2!1,5)555@26419L13,556@26490L32,557@26571L48,567@26938L32,568@27008L30,571@27123L190,561@26722L591:IconButton.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                border2 = border;
                int i6 = $composer2.changed(border2) ? 1048576 : 524288;
                $dirty2 |= i6;
            } else {
                border2 = border;
            }
            $dirty2 |= i6;
        } else {
            border2 = border;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 12582912) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 8388608 : 4194304;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty2) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            shape4 = shape2;
            colors4 = colors2;
            border4 = border2;
            interactionSource3 = mutableInteractionSource;
            enabled4 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = IconButtonDefaults.INSTANCE.getOutlinedShape($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonColors($composer2, 6);
                }
                if ((i & 64) != 0) {
                    BorderStroke border5 = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonBorder(enabled2, checked, $composer2, (($dirty2 >> 9) & 14) | 384 | (($dirty2 << 3) & 112));
                    $dirty2 &= -3670017;
                    border2 = border5;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                    border3 = border2;
                    interactionSource2 = null;
                    modifier3 = modifier2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    border3 = border2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    border3 = border2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    border3 = border2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1470292106, $dirty, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:561)");
            }
            Modifier modifier5 = modifier3;
            IconToggleButtonColors colors5 = colors3;
            SurfaceKt.m2563Surfaced85dljk(checked, function1, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5957getCheckboxo7Vup1c());
                }
            }, 1, null), enabled3, shape3, colors3.containerColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 9) & 896)).getValue().m4197unboximpl(), colors3.contentColor$material3_release(enabled3, checked, $composer2, (($dirty >> 9) & 896) | (($dirty >> 9) & 14) | (($dirty << 3) & 112)).getValue().m4197unboximpl(), 0.0f, 0.0f, border3, interactionSource2, ComposableLambdaKt.rememberComposableLambda(1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C572@27133L174:IconButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1207657396, $changed2, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:572)");
                        }
                        Modifier modifier$iv = SizeKt.m726size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3371getContainerSizeD9Ej5fM());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i9 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 278710712, "C576@27288L9:IconButton.kt#uh7d8r");
                        function22.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | (57344 & $dirty) | (1879048192 & ($dirty << 9)), (($dirty >> 21) & 14) | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            border4 = border3;
            interactionSource3 = interactionSource2;
            colors4 = colors5;
            enabled4 = enabled3;
            modifier4 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.3
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

                public final void invoke(Composer composer, int i8) {
                    IconButtonKt.OutlinedIconToggleButton(checked, function1, modifier4, enabled4, shape4, colors4, border4, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
