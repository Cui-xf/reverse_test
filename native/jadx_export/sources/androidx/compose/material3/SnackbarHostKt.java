package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SnackbarHost.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "snackbar", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    /* compiled from: SnackbarHost.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void SnackbarHost(SnackbarHostState hostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        SnackbarHostState snackbarHostState;
        Modifier modifier2;
        Function3 snackbar;
        SnackbarHostKt$SnackbarHost$1$1 value$iv;
        final Function3 snackbar2;
        Composer $composer2 = $composer.startRestartGroup(464178177);
        ComposerKt.sourceInformation($composer2, "C(SnackbarHost)223@9468L7,224@9516L348,224@9480L384,235@9869L134:SnackbarHost.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            snackbarHostState = hostState;
        } else if (($changed & 6) == 0) {
            snackbarHostState = hostState;
            $dirty |= $composer2.changed(snackbarHostState) ? 4 : 2;
        } else {
            snackbarHostState = hostState;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            snackbar = function3;
        } else if (($changed & 384) == 0) {
            snackbar = function3;
            $dirty |= $composer2.changedInstance(snackbar) ? 256 : 128;
        } else {
            snackbar = function3;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            snackbar2 = snackbar;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                snackbar = ComposableSingletons$SnackbarHostKt.INSTANCE.m1999getLambda1$material3_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464178177, $dirty2, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)");
            }
            SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
            ProvidableCompositionLocal<AccessibilityManager> localAccessibilityManager = CompositionLocalsKt.getLocalAccessibilityManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAccessibilityManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AccessibilityManager accessibilityManager = (AccessibilityManager) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer2, -487334772, "CC(remember):SnackbarHost.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(currentSnackbarData) | $composer2.changedInstance(accessibilityManager);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SnackbarHostKt$SnackbarHost$1$1(currentSnackbarData, accessibilityManager, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(currentSnackbarData, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv, $composer2, 0);
            Modifier modifier4 = modifier3;
            FadeInFadeOutWithScale(snackbarHostState.getCurrentSnackbarData(), modifier4, snackbar, $composer2, ($dirty2 & 896) | ($dirty2 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
            snackbar2 = snackbar;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final SnackbarHostState snackbarHostState2 = snackbarHostState;
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt.SnackbarHost.2
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

                public final void invoke(Composer composer, int i4) {
                    SnackbarHostKt.SnackbarHost(snackbarHostState2, modifier5, snackbar2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final long toMillis(SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
        long j;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toMillis.ordinal()]) {
            case 1:
                j = Long.MAX_VALUE;
                break;
            case 2:
                j = 10000;
                break;
            case 3:
                j = 4000;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        long original = j;
        if (accessibilityManager == null) {
            return original;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(original, true, true, hasAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FadeInFadeOutWithScale(final SnackbarData current, Modifier modifier, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        int $dirty;
        final Modifier modifier3;
        final SnackbarData snackbarData = current;
        final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function32 = function3;
        Composer $composer2 = $composer.startRestartGroup(-1316639904);
        ComposerKt.sourceInformation($composer2, "C(FadeInFadeOutWithScale)P(1,2)328@12730L48,393@15387L162:SnackbarHost.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function32) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1316639904, $dirty3, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1256815738, "CC(remember):SnackbarHost.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new FadeInFadeOutState();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final FadeInFadeOutState state = (FadeInFadeOutState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-1256811491);
            ComposerKt.sourceInformation($composer2, "*337@13129L2237");
            if (Intrinsics.areEqual(snackbarData, state.getCurrent())) {
                $dirty = $dirty3;
            } else {
                state.setCurrent(snackbarData);
                List $this$fastMap$iv = state.getItems();
                List target$iv = new ArrayList($this$fastMap$iv.size());
                int size = $this$fastMap$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                    FadeInFadeOutAnimationItem it = (FadeInFadeOutAnimationItem) item$iv$iv;
                    target$iv.add((SnackbarData) it.getKey());
                }
                final List keys = CollectionsKt.toMutableList((Collection) target$iv);
                if (!keys.contains(snackbarData)) {
                    keys.add(snackbarData);
                }
                state.getItems().clear();
                List $this$fastMapTo$iv = ListUtilsKt.fastFilterNotNull(keys);
                Collection destination$iv = state.getItems();
                int $i$f$fastMapTo = 0;
                int index$iv$iv2 = 0;
                int size2 = $this$fastMapTo$iv.size();
                while (index$iv$iv2 < size2) {
                    Object item$iv$iv2 = $this$fastMapTo$iv.get(index$iv$iv2);
                    final SnackbarData key = (SnackbarData) item$iv$iv2;
                    destination$iv.add(new FadeInFadeOutAnimationItem(key, ComposableLambdaKt.rememberComposableLambda(-1654683077, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer3, int $changed2) {
                            int i3;
                            TweenSpec tweenSpec;
                            Object value$iv2;
                            Object value$iv3;
                            Function0 factory$iv$iv$iv;
                            ComposerKt.sourceInformation($composer3, "C356@14017L313,348@13634L718,365@14401L364,380@15042L241,374@14782L570:SnackbarHost.kt#uh7d8r");
                            int $dirty4 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty4 |= $composer3.changedInstance(function2) ? 4 : 2;
                            }
                            int $dirty5 = $dirty4;
                            if (($dirty5 & 19) != 18 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1654683077, $dirty5, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
                                }
                                boolean isVisible = Intrinsics.areEqual(key, snackbarData);
                                int duration = isVisible ? 150 : 75;
                                if (isVisible && ListUtilsKt.fastFilterNotNull(keys).size() != 1) {
                                    i3 = 75;
                                } else {
                                    i3 = 0;
                                }
                                int animationDelay = i3;
                                TweenSpec tweenSpecTween = AnimationSpecKt.tween(duration, animationDelay, EasingKt.getLinearEasing());
                                ComposerKt.sourceInformationMarkerStart($composer3, 1201029357, "CC(remember):SnackbarHost.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(key) | $composer3.changedInstance(state);
                                final SnackbarData snackbarData2 = key;
                                final FadeInFadeOutState<SnackbarData> fadeInFadeOutState = state;
                                Object it$iv2 = $composer3.rememberedValue();
                                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    tweenSpec = tweenSpecTween;
                                    value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                                                List<FadeInFadeOutAnimationItem<SnackbarData>> items = fadeInFadeOutState.getItems();
                                                final SnackbarData snackbarData3 = snackbarData2;
                                                CollectionsKt.removeAll((List) items, (Function1) new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(FadeInFadeOutAnimationItem<SnackbarData> fadeInFadeOutAnimationItem) {
                                                        return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), snackbarData3));
                                                    }
                                                });
                                                RecomposeScope scope = fadeInFadeOutState.getScope();
                                                if (scope != null) {
                                                    scope.invalidate();
                                                }
                                            }
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv2);
                                } else {
                                    tweenSpec = tweenSpecTween;
                                    value$iv2 = it$iv2;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                State opacity = SnackbarHostKt.animatedOpacity(tweenSpec, isVisible, (Function0) value$iv2, $composer3, 0, 0);
                                State scale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(duration, animationDelay, EasingKt.getFastOutSlowInEasing()), isVisible, $composer3, 0);
                                Modifier modifierM4347graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4347graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, ((Number) scale.getValue()).floatValue(), ((Number) scale.getValue()).floatValue(), ((Number) opacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                ComposerKt.sourceInformationMarkerStart($composer3, 1201062085, "CC(remember):SnackbarHost.kt#9igjgp");
                                boolean invalid$iv2 = $composer3.changed(key);
                                final SnackbarData snackbarData3 = key;
                                Object it$iv3 = $composer3.rememberedValue();
                                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
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
                                            SemanticsPropertiesKt.m5974setLiveRegionhR3wRGc($this$semantics, LiveRegionMode.INSTANCE.m5948getPolite0phEisY());
                                            final SnackbarData snackbarData4 = snackbarData3;
                                            SemanticsPropertiesKt.dismiss$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    snackbarData4.dismiss();
                                                    return true;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv3;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifier$iv = SemanticsModifierKt.semantics$default(modifierM4347graphicsLayerAp8cVGQ$default, false, (Function1) value$iv3, 1, null);
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
                                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i5 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -514884474, "C388@15324L10:SnackbarHost.kt#uh7d8r");
                                function2.invoke($composer3, Integer.valueOf($dirty5 & 14));
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
                    }, $composer2, 54)));
                    index$iv$iv2++;
                    snackbarData = current;
                    $this$fastMapTo$iv = $this$fastMapTo$iv;
                    $dirty3 = $dirty3;
                    keys = keys;
                    $i$f$fastMapTo = $i$f$fastMapTo;
                }
                $dirty = $dirty3;
            }
            $composer2.endReplaceGroup();
            int $changed$iv = ($dirty >> 3) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier4);
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
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
            int $changed2 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1643979990, "C394@15425L21:SnackbarHost.kt#uh7d8r");
            state.setScope(ComposablesKt.getCurrentRecomposeScope($composer2, 0));
            $composer2.startReplaceGroup(1748085441);
            ComposerKt.sourceInformation($composer2, "");
            List $this$fastForEach$iv = state.getItems();
            int size3 = $this$fastForEach$iv.size();
            int $i$f$fastForEach = 0;
            while ($i$f$fastForEach < size3) {
                Object item$iv = $this$fastForEach$iv.get($i$f$fastForEach);
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) item$iv;
                int i4 = size3;
                final SnackbarData item = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                List $this$fastForEach$iv2 = $this$fastForEach$iv;
                Function3 opacity = fadeInFadeOutAnimationItem.component2();
                int index$iv = $i$f$fastForEach;
                $composer2.startMovableGroup(1201076541, item);
                ComposerKt.sourceInformation($composer2, "395@15520L19,395@15512L27");
                opacity.invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
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

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C395@15522L15:SnackbarHost.kt#uh7d8r");
                        if (($changed3 & 3) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1135367807, $changed3, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
                        }
                        Function3<SnackbarData, Composer, Integer, Unit> function33 = function32;
                        SnackbarData snackbarData2 = item;
                        Intrinsics.checkNotNull(snackbarData2);
                        function33.invoke(snackbarData2, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, 6);
                $composer2.endMovableGroup();
                $i$f$fastForEach = index$iv + 1;
                $changed2 = $changed2;
                function32 = function3;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                size3 = i4;
            }
            $composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt.FadeInFadeOutWithScale.3
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

                public final void invoke(Composer composer, int i5) {
                    SnackbarHostKt.FadeInFadeOutWithScale(current, modifier3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean visible, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Object value$iv;
        Animatable alpha;
        SnackbarHostKt$animatedOpacity$2$1 value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 1431889134, "C(animatedOpacity)P(!1,2)419@16197L49,420@16275L111,420@16251L135:SnackbarHost.kt#uh7d8r");
        Function0 onAnimationFinish = (i & 4) != 0 ? new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt.animatedOpacity.1
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
            ComposerKt.traceEventStart(1431889134, $changed, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2104079446, "CC(remember):SnackbarHost.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.0f, 0.0f, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        Animatable alpha2 = (Animatable) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Boolean boolValueOf = Boolean.valueOf(visible);
        ComposerKt.sourceInformationMarkerStart($composer, 2104082004, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(alpha2) | (((($changed & 112) ^ 48) > 32 && $composer.changed(visible)) || ($changed & 48) == 32) | $composer.changedInstance(animationSpec) | (((($changed & 896) ^ 384) > 256 && $composer.changed(onAnimationFinish)) || ($changed & 384) == 256);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            alpha = alpha2;
            value$iv2 = new SnackbarHostKt$animatedOpacity$2$1(alpha, visible, animationSpec, onAnimationFinish, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            alpha = alpha2;
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, ($changed >> 3) & 14);
        State<Float> stateAsState = alpha.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean visible, Composer $composer, int $changed) {
        Object value$iv;
        SnackbarHostKt$animatedScale$1$1 value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 1966809761, "C(animatedScale)429@16538L51,430@16618L85,430@16594L109:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, $changed, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1433330423, "CC(remember):SnackbarHost.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.8f, 0.0f, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        Animatable scale = (Animatable) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Boolean boolValueOf = Boolean.valueOf(visible);
        ComposerKt.sourceInformationMarkerStart($composer, 1433333017, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(scale) | (((($changed & 112) ^ 48) > 32 && $composer.changed(visible)) || ($changed & 48) == 32) | $composer.changedInstance(animationSpec);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new SnackbarHostKt$animatedScale$1$1(scale, visible, animationSpec, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, ($changed >> 3) & 14);
        State<Float> stateAsState = scale.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateAsState;
    }
}
