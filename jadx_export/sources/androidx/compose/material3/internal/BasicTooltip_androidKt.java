package androidx.compose.material3.internal;

import android.content.res.Resources;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.R;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: BasicTooltip.android.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTooltip_androidKt {
    public static final void BasicTooltipBox(final PopupPositionProvider positionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, TooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) throws Resources.NotFoundException {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        boolean focusable2;
        boolean enableUserInput2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Object value$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        boolean focusable3;
        Object value$iv;
        final boolean enableUserInput3;
        final Modifier modifier3;
        final boolean focusable4;
        final TooltipState tooltipState = state;
        Composer $composer3 = $composer.startRestartGroup(-550509567);
        ComposerKt.sourceInformation($composer3, "C(BasicTooltipBox)P(4,6,5,3,2,1)86@3910L24,87@3939L451,106@4420L35,106@4396L59:BasicTooltip.android.kt#mqatfk");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(positionProvider) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            function23 = function2;
        } else if (($changed & 48) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 32 : 16;
        } else {
            function23 = function2;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(tooltipState) : $composer3.changedInstance(tooltipState) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            focusable2 = focusable;
        } else if (($changed & 24576) == 0) {
            focusable2 = focusable;
            $dirty |= $composer3.changed(focusable2) ? 16384 : 8192;
        } else {
            focusable2 = focusable;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enableUserInput2 = enableUserInput;
        } else if ((196608 & $changed) == 0) {
            enableUserInput2 = enableUserInput;
            $dirty |= $composer3.changed(enableUserInput2) ? 131072 : 65536;
        } else {
            enableUserInput2 = enableUserInput;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
            function24 = function22;
        } else if (($changed & 1572864) == 0) {
            function24 = function22;
            $dirty |= $composer3.changedInstance(function24) ? 1048576 : 524288;
        } else {
            function24 = function22;
        }
        int $dirty2 = $dirty;
        if ((599187 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            focusable4 = focusable2;
            enableUserInput3 = enableUserInput2;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                focusable2 = true;
            }
            if (i4 != 0) {
                enableUserInput2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-550509567, $dirty2, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.android.kt:85)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2072656365, "C98@4223L161:BasicTooltip.android.kt#mqatfk");
            $composer3.startReplaceGroup(-625876949);
            ComposerKt.sourceInformation($composer3, "89@3988L215");
            if (state.getIsVisible()) {
                $composer$iv = $composer3;
                boolean focusable5 = focusable2;
                TooltipPopup(positionProvider, state, scope, focusable5, function23, $composer3, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 7168) | (($dirty2 << 9) & 57344));
                focusable3 = focusable5;
                $composer2 = $composer3;
            } else {
                $composer$iv = $composer3;
                $composer2 = $composer3;
                focusable3 = focusable2;
            }
            $composer2.endReplaceGroup();
            tooltipState = state;
            boolean enableUserInput4 = enableUserInput2;
            WrappedAnchor(enableUserInput4, tooltipState, modifier5, function24, $composer2, (($dirty2 >> 15) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 >> 9) & 7168), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1907285077, "CC(remember):BasicTooltip.android.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer3.changedInstance(tooltipState));
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final TooltipState tooltipState2 = tooltipState;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                tooltipState2.onDispose();
                            }
                        };
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(tooltipState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv, $composer3, ($dirty2 >> 6) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enableUserInput3 = enableUserInput4;
            modifier3 = modifier5;
            focusable4 = focusable3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TooltipState tooltipState2 = tooltipState;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.BasicTooltipBox.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) throws Resources.NotFoundException {
                    BasicTooltip_androidKt.BasicTooltipBox(positionProvider, function2, tooltipState2, modifier3, focusable4, enableUserInput3, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WrappedAnchor(final boolean enableUserInput, final TooltipState state, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) throws Resources.NotFoundException {
        Modifier modifier2;
        Object value$iv$iv;
        Function0 factory$iv$iv$iv;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1848240995);
        ComposerKt.sourceInformation($composer2, "C(WrappedAnchor)P(1,3,2)116@4644L24,117@4694L38,118@4737L212:BasicTooltip.android.kt#mqatfk");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enableUserInput) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848240995, $dirty2, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.android.kt:115)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String longPressLabel = StringResources_androidKt.stringResource(R.string.tooltip_label, $composer2, 0);
            Modifier modifier$iv = anchorSemantics(handleGestures(modifier4, enableUserInput, state), longPressLabel, enableUserInput, state, scope);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier4;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 400210223, "C124@4934L9:BasicTooltip.android.kt#mqatfk");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.WrappedAnchor.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) throws Resources.NotFoundException {
                    BasicTooltip_androidKt.WrappedAnchor(enableUserInput, state, modifier3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TooltipPopup(final PopupPositionProvider positionProvider, final TooltipState state, final CoroutineScope scope, final boolean focusable, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) throws Resources.NotFoundException {
        PopupPositionProvider popupPositionProvider;
        boolean z;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-273292979);
        ComposerKt.sourceInformation($composer2, "C(TooltipPopup)P(2,4,3,1)136@5181L44,139@5314L109,145@5491L251,137@5230L512:BasicTooltip.android.kt#mqatfk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            popupPositionProvider = positionProvider;
            $dirty |= $composer2.changed(popupPositionProvider) ? 4 : 2;
        } else {
            popupPositionProvider = positionProvider;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            z = focusable;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = focusable;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if (($dirty & 9363) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273292979, $dirty, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.android.kt:135)");
            }
            boolean z2 = false;
            final String tooltipDescription = StringResources_androidKt.stringResource(R.string.tooltip_description, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 162917156, "CC(remember):BasicTooltip.android.kt#9igjgp");
            if (($dirty & 112) == 32 || (($dirty & 64) != 0 && $composer2.changedInstance(state))) {
                z2 = true;
            }
            boolean invalid$iv = z2 | $composer2.changedInstance(scope);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: BasicTooltip.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TooltipState tooltipState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    this.$state.dismiss();
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (state.getIsVisible()) {
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(state, null), 3, null);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidPopup_androidKt.Popup(popupPositionProvider, (Function0) value$iv, new PopupProperties(z, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(610617071, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.TooltipPopup.2
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
                    Object value$iv2;
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C148@5564L128,146@5501L235:BasicTooltip.android.kt#mqatfk");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(610617071, $changed2, -1, "androidx.compose.material3.internal.TooltipPopup.<anonymous> (BasicTooltip.android.kt:146)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1377587702, "CC(remember):BasicTooltip.android.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(tooltipDescription);
                        final String str = tooltipDescription;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$2$1$1
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
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                    SemanticsPropertiesKt.m5974setLiveRegionhR3wRGc($this$semantics, LiveRegionMode.INSTANCE.m5947getAssertive0phEisY());
                                    SemanticsPropertiesKt.setPaneTitle($this$semantics, str);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv2, 1, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1900261851, "C153@5717L9:BasicTooltip.android.kt#mqatfk");
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
            }, $composer2, 54), $composer2, ($dirty & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.TooltipPopup.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) throws Resources.NotFoundException {
                    BasicTooltip_androidKt.TooltipPopup(positionProvider, state, scope, focusable, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* compiled from: BasicTooltip.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1", f = "BasicTooltip.android.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1, reason: invalid class name and case insensitive filesystem */
    static final class C05661 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05661(TooltipState tooltipState, Continuation<? super C05661> continuation) {
            super(2, continuation);
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05661 c05661 = new C05661(this.$state, continuation);
            c05661.L$0 = obj;
            return c05661;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C05661) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BasicTooltip.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1", f = "BasicTooltip.android.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ TooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01351(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super C01351> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01351 c01351 = new C01351(this.$$this$pointerInput, this.$state, continuation);
                c01351.L$0 = obj;
                return c01351;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: BasicTooltip.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1", f = "BasicTooltip.android.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {171, 177, 197}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "isLongPressedFlow", "pass", "longPressTimeout", "$this$awaitEachGesture", "isLongPressedFlow", "pass", "isLongPressedFlow"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C01361 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ TooltipState $state;
                long J$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01361(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C01361> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01361 c01361 = new C01361(this.$$this$coroutineScope, this.$state, continuation);
                    c01361.L$0 = obj;
                    return c01361;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C01361) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:30:0x00d8 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x0111 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0118 A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #4 {all -> 0x0127, blocks: (B:40:0x0114, B:42:0x0118), top: B:55:0x0114 }] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instructions count: 318
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C05661.C01351.C01361.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* compiled from: BasicTooltip.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                static final class C01371 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                    final /* synthetic */ PointerEventPass $pass;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01371(PointerEventPass pointerEventPass, Continuation<? super C01371> continuation) {
                        super(2, continuation);
                        this.$pass = pointerEventPass;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C01371 c01371 = new C01371(this.$pass, continuation);
                        c01371.L$0 = obj;
                        return c01371;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                        return ((C01371) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                                this.label = 1;
                                Object objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, this.$pass, this);
                                return objWaitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                return $result;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                /* compiled from: BasicTooltip.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2", f = "BasicTooltip.android.kt", i = {}, l = {185, 187, 187}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableStateFlow<Boolean> $isLongPressedFlow;
                    final /* synthetic */ TooltipState $state;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(MutableStateFlow<Boolean> mutableStateFlow, TooltipState tooltipState, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$isLongPressedFlow = mutableStateFlow;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$isLongPressedFlow, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
                    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
                    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2] */
                    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2] */
                    /* JADX WARN: Type inference failed for: r1v5 */
                    /* JADX WARN: Type inference failed for: r1v9 */
                    /* JADX WARN: Type inference failed for: r2v0 */
                    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.Continuation] */
                    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                        /*
                            r7 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r7.label
                            r2 = 0
                            switch(r1) {
                                case 0: goto L28;
                                case 1: goto L21;
                                case 2: goto L1c;
                                case 3: goto L12;
                                default: goto La;
                            }
                        La:
                            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r8.<init>(r0)
                            throw r8
                        L12:
                            r0 = r7
                            java.lang.Object r1 = r0.L$0
                            java.lang.Throwable r1 = (java.lang.Throwable) r1
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L84
                        L1c:
                            r0 = r7
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L62
                        L21:
                            r1 = r7
                            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L26
                            goto L47
                        L26:
                            r3 = move-exception
                            goto L66
                        L28:
                            kotlin.ResultKt.throwOnFailure(r8)
                            r1 = r7
                            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r3 = r1.$isLongPressedFlow     // Catch: java.lang.Throwable -> L26
                            r4 = 1
                            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L26
                            r3.tryEmit(r5)     // Catch: java.lang.Throwable -> L26
                            androidx.compose.material3.TooltipState r3 = r1.$state     // Catch: java.lang.Throwable -> L26
                            androidx.compose.foundation.MutatePriority r5 = androidx.compose.foundation.MutatePriority.PreventUserInput     // Catch: java.lang.Throwable -> L26
                            r6 = r1
                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L26
                            r1.label = r4     // Catch: java.lang.Throwable -> L26
                            java.lang.Object r3 = r3.show(r5, r6)     // Catch: java.lang.Throwable -> L26
                            if (r3 != r0) goto L47
                            return r0
                        L47:
                            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r3 = r1.$isLongPressedFlow
                            kotlinx.coroutines.flow.Flow r3 = (kotlinx.coroutines.flow.Flow) r3
                            androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r4 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                            androidx.compose.material3.TooltipState r5 = r1.$state
                            r4.<init>(r5, r2)
                            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                            r2 = r1
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            r5 = 2
                            r1.label = r5
                            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collectLatest(r3, r4, r2)
                            if (r2 != r0) goto L61
                            return r0
                        L61:
                            r0 = r1
                        L62:
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                            return r1
                        L66:
                            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r4 = r1.$isLongPressedFlow
                            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
                            androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r5 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                            androidx.compose.material3.TooltipState r6 = r1.$state
                            r5.<init>(r6, r2)
                            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                            r2 = r1
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            r1.L$0 = r3
                            r6 = 3
                            r1.label = r6
                            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collectLatest(r4, r5, r2)
                            if (r2 != r0) goto L82
                            return r0
                        L82:
                            r0 = r1
                            r1 = r3
                        L84:
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C05661.C01351.C01361.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* compiled from: BasicTooltip.android.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isLongPressed", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1", f = "BasicTooltip.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1, reason: invalid class name and collision with other inner class name */
                    static final class C01381 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TooltipState $state;
                        /* synthetic */ boolean Z$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C01381(TooltipState tooltipState, Continuation<? super C01381> continuation) {
                            super(2, continuation);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C01381 c01381 = new C01381(this.$state, continuation);
                            c01381.Z$0 = ((Boolean) obj).booleanValue();
                            return c01381;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                            return invoke(bool.booleanValue(), continuation);
                        }

                        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                            return ((C01381) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    boolean isLongPressed = this.Z$0;
                                    if (!isLongPressed) {
                                        this.$state.dismiss();
                                    }
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C01361($this$coroutineScope, this.$state, null), this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new C01351($this$pointerInput, this.$state, null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private static final Modifier handleGestures(Modifier $this$handleGestures, boolean enabled, TooltipState state) {
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput($this$handleGestures, state, new C05661(state, null)), state, new C05672(state, null));
        }
        return $this$handleGestures;
    }

    /* compiled from: BasicTooltip.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2", f = "BasicTooltip.android.kt", i = {}, l = {ComposerKt.reuseKey}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2, reason: invalid class name and case insensitive filesystem */
    static final class C05672 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05672(TooltipState tooltipState, Continuation<? super C05672> continuation) {
            super(2, continuation);
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05672 c05672 = new C05672(this.$state, continuation);
            c05672.L$0 = obj;
            return c05672;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C05672) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BasicTooltip.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1", f = "BasicTooltip.android.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ TooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: BasicTooltip.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1", f = "BasicTooltip.android.kt", i = {0, 0}, l = {212}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            static final class C01391 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ TooltipState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01391(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C01391> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01391 c01391 = new C01391(this.$$this$coroutineScope, this.$state, continuation);
                    c01391.L$0 = obj;
                    return c01391;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C01391) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0041 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0042 -> B:12:0x0049). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                    /*
                        r13 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r13.label
                        switch(r1) {
                            case 0: goto L23;
                            case 1: goto L11;
                            default: goto L9;
                        }
                    L9:
                        java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r14.<init>(r0)
                        throw r14
                    L11:
                        r1 = r13
                        java.lang.Object r2 = r1.L$1
                        androidx.compose.ui.input.pointer.PointerEventPass r2 = (androidx.compose.ui.input.pointer.PointerEventPass) r2
                        java.lang.Object r3 = r1.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                        kotlin.ResultKt.throwOnFailure(r14)
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r0
                        r0 = r14
                        goto L49
                    L23:
                        kotlin.ResultKt.throwOnFailure(r14)
                        r1 = r13
                        java.lang.Object r2 = r1.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                        r12 = r3
                        r3 = r2
                        r2 = r12
                    L30:
                        r4 = r1
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r1.L$0 = r3
                        r1.L$1 = r2
                        r5 = 1
                        r1.label = r5
                        java.lang.Object r4 = r3.awaitPointerEvent(r2, r4)
                        if (r4 != r0) goto L42
                        return r0
                    L42:
                        r12 = r0
                        r0 = r14
                        r14 = r4
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r12
                    L49:
                        androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
                        java.util.List r5 = r14.getChanges()
                        r6 = 0
                        java.lang.Object r5 = r5.get(r6)
                        androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                        int r5 = r5.getType()
                        androidx.compose.ui.input.pointer.PointerType$Companion r6 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                        int r6 = r6.m5482getMouseT8wyACA()
                        boolean r6 = androidx.compose.ui.input.pointer.PointerType.m5477equalsimpl0(r5, r6)
                        if (r6 == 0) goto L9b
                        int r5 = r14.getType()
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r14 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                        int r14 = r14.m5357getEnter7fucELk()
                        boolean r14 = androidx.compose.ui.input.pointer.PointerEventType.m5353equalsimpl0(r5, r14)
                        if (r14 == 0) goto L8a
                        kotlinx.coroutines.CoroutineScope r6 = r2.$$this$coroutineScope
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1 r14 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1
                        androidx.compose.material3.TooltipState r5 = r2.$state
                        r7 = 0
                        r14.<init>(r5, r7)
                        r9 = r14
                        kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                        r10 = 3
                        r11 = 0
                        r8 = 0
                        kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
                        goto L9b
                    L8a:
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r14 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                        int r14 = r14.m5358getExit7fucELk()
                        boolean r14 = androidx.compose.ui.input.pointer.PointerEventType.m5353equalsimpl0(r5, r14)
                        if (r14 == 0) goto L9b
                        androidx.compose.material3.TooltipState r14 = r2.$state
                        r14.dismiss()
                    L9b:
                        r14 = r0
                        r0 = r1
                        r1 = r2
                        r2 = r3
                        r3 = r4
                        goto L30
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C05672.AnonymousClass1.C01391.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* compiled from: BasicTooltip.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ TooltipState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01401(TooltipState tooltipState, Continuation<? super C01401> continuation) {
                        super(2, continuation);
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01401(this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, this) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (this.$$this$pointerInput.awaitPointerEventScope(new C01391($this$coroutineScope, this.$state, null), this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$pointerInput, this.$state, null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private static final Modifier anchorSemantics(Modifier $this$anchorSemantics, final String label, boolean enabled, final TooltipState state, final CoroutineScope scope) {
        if (enabled) {
            return SemanticsModifierKt.semantics($this$anchorSemantics, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.anchorSemantics.1
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
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    String str = label;
                    final CoroutineScope coroutineScope = scope;
                    final TooltipState tooltipState = state;
                    SemanticsPropertiesKt.onLongClick($this$semantics, str, new Function0<Boolean>() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.anchorSemantics.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* compiled from: BasicTooltip.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$anchorSemantics$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$anchorSemantics$1$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TooltipState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C01341(TooltipState tooltipState, Continuation<? super C01341> continuation) {
                                super(2, continuation);
                                this.$state = tooltipState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C01341(this.$state, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C01341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (TooltipState.CC.show$default(this.$state, null, this, 1, null) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01341(tooltipState, null), 3, null);
                            return true;
                        }
                    });
                }
            });
        }
        return $this$anchorSemantics;
    }
}
