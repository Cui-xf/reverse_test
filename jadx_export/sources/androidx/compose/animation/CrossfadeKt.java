package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Crossfade.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u008a\u0084\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossfadeKt {
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String label, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        FiniteAnimationSpec finiteAnimationSpec2;
        String str;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function32;
        final String label2;
        final Modifier modifier3;
        final FiniteAnimationSpec animationSpec;
        Composer $composer2 = $composer.startRestartGroup(-310686752);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(4,3!1,2)56@2327L36,57@2379L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(t) : $composer2.changedInstance(t) ? 4 : 2;
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
            finiteAnimationSpec2 = finiteAnimationSpec;
        } else if (($changed & 384) == 0) {
            finiteAnimationSpec2 = finiteAnimationSpec;
            $dirty |= $composer2.changedInstance(finiteAnimationSpec2) ? 256 : 128;
        } else {
            finiteAnimationSpec2 = finiteAnimationSpec;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            str = label;
        } else if (($changed & 3072) == 0) {
            str = label;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = label;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
            function32 = function3;
        } else if (($changed & 24576) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? 16384 : 8192;
        } else {
            function32 = function3;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            animationSpec = finiteAnimationSpec2;
            label2 = str;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            FiniteAnimationSpec animationSpec2 = i3 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec2;
            String label3 = i4 != 0 ? "Crossfade" : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310686752, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(t, label3, $composer2, ($dirty2 & 8) | ($dirty2 & 14) | (($dirty2 >> 6) & 112), 0);
            Modifier modifier5 = modifier4;
            FiniteAnimationSpec animationSpec3 = animationSpec2;
            Crossfade(transition, modifier5, (FiniteAnimationSpec<Float>) animationSpec3, (Function1) null, function32, $composer2, ($dirty2 & 112) | ($dirty2 & 896) | (57344 & $dirty2), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label2 = label3;
            modifier3 = modifier5;
            animationSpec = animationSpec3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
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
                    CrossfadeKt.Crossfade(t, modifier3, animationSpec, label2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object targetState, Modifier modifier, FiniteAnimationSpec animationSpec, final Function3 content, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        FiniteAnimationSpec finiteAnimationSpec;
        Function3 function3;
        final Modifier modifier3;
        final FiniteAnimationSpec animationSpec2;
        Composer $composer2 = $composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3,2)72@2790L29,73@2835L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(targetState) : $composer2.changedInstance(targetState) ? 4 : 2;
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
            finiteAnimationSpec = animationSpec;
        } else if (($changed & 384) == 0) {
            finiteAnimationSpec = animationSpec;
            $dirty |= $composer2.changedInstance(finiteAnimationSpec) ? 256 : 128;
        } else {
            finiteAnimationSpec = animationSpec;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
            function3 = content;
        } else if (($changed & 3072) == 0) {
            function3 = content;
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = content;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            animationSpec2 = finiteAnimationSpec;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            FiniteAnimationSpec animationSpec3 = i3 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:71)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(targetState, (String) null, $composer2, ($dirty2 & 8) | ($dirty2 & 14), 2);
            Modifier modifier5 = modifier4;
            Crossfade(transition, modifier5, (FiniteAnimationSpec<Float>) animationSpec3, (Function1) null, function3, $composer2, ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            animationSpec2 = animationSpec3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) throws Throwable {
                    CrossfadeKt.Crossfade(targetState, modifier3, animationSpec2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        FiniteAnimationSpec animationSpec;
        Function1 contentKey;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        SnapshotStateList currentlyVisible;
        Function0 factory$iv$iv$iv;
        final Modifier modifier4;
        final FiniteAnimationSpec animationSpec2;
        final Function1 contentKey2;
        Object value$iv3;
        final Transition<T> transition2 = transition;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function32 = function3;
        Composer $composer2 = $composer.startRestartGroup(679005231);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3!1,2)104@4422L64,105@4508L61,137@5785L159:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(transition2) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            animationSpec = finiteAnimationSpec;
        } else if (($changed & 384) == 0) {
            animationSpec = finiteAnimationSpec;
            $dirty |= $composer2.changedInstance(animationSpec) ? 256 : 128;
        } else {
            animationSpec = finiteAnimationSpec;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            contentKey = function1;
        } else if (($changed & 3072) == 0) {
            contentKey = function1;
            $dirty |= $composer2.changedInstance(contentKey) ? 2048 : 1024;
        } else {
            contentKey = function1;
        }
        if ((i & 8) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            animationSpec2 = animationSpec;
            contentKey2 = contentKey;
        } else {
            Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                animationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            if (i4 != 0) {
                contentKey = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.3
                    @Override // kotlin.jvm.functions.Function1
                    public final T invoke(T t) {
                        return t;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(679005231, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:103)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1274683025, "CC(remember):Crossfade.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList $this$Crossfade_u24lambda_u241_u24lambda_u240 = SnapshotStateKt.mutableStateListOf();
                $this$Crossfade_u24lambda_u241_u24lambda_u240.add(transition2.getCurrentState());
                value$iv = $this$Crossfade_u24lambda_u241_u24lambda_u240;
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList currentlyVisible2 = (SnapshotStateList) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1274685774, "CC(remember):Crossfade.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = ScatterMapKt.mutableScatterMapOf();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableScatterMap contentMap = (MutableScatterMap) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                $composer2.startReplaceGroup(860660313);
                ComposerKt.sourceInformation($composer2, "");
                if (currentlyVisible2.size() == 1 && Intrinsics.areEqual(currentlyVisible2.get(0), transition2.getTargetState())) {
                    $composer2.startReplaceGroup(860984945);
                    $composer2.endReplaceGroup();
                    modifier3 = modifier5;
                } else {
                    $composer2.startReplaceGroup(860794667);
                    ComposerKt.sourceInformation($composer2, "110@4883L21");
                    SnapshotStateList snapshotStateList = currentlyVisible2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1274697734, "CC(remember):Crossfade.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 14) == 4;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv) {
                        modifier3 = modifier5;
                    } else {
                        modifier3 = modifier5;
                        if (it$iv3 != Composer.INSTANCE.getEmpty()) {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        CollectionsKt.removeAll((List) snapshotStateList, (Function1) value$iv3);
                        contentMap.clear();
                        $composer2.endReplaceGroup();
                    }
                    value$iv3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(T t) {
                            return Boolean.valueOf(!Intrinsics.areEqual(t, transition2.getTargetState()));
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                            return invoke((CrossfadeKt$Crossfade$4$1<T>) obj);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    CollectionsKt.removeAll((List) snapshotStateList, (Function1) value$iv3);
                    contentMap.clear();
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
            } else {
                modifier3 = modifier5;
                $composer2.startReplaceGroup(860990897);
                $composer2.endReplaceGroup();
            }
            if (contentMap.contains(transition2.getTargetState())) {
                currentlyVisible = currentlyVisible2;
                $composer2.startReplaceGroup(861812273);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(861052122);
                ComposerKt.sourceInformation($composer2, "*126@5458L305");
                SnapshotStateList $this$indexOfFirst$iv = currentlyVisible2;
                int $i$f$indexOfFirst = 0;
                int index$iv = 0;
                Iterator<T> it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        index$iv = -1;
                        break;
                    }
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    int $i$f$indexOfFirst2 = $i$f$indexOfFirst;
                    if (Intrinsics.areEqual(contentKey.invoke(it.next()), contentKey.invoke(transition2.getTargetState()))) {
                        break;
                    }
                    index$iv++;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                    $i$f$indexOfFirst = $i$f$indexOfFirst2;
                }
                if (index$iv == -1) {
                    currentlyVisible2.add(transition2.getTargetState());
                } else {
                    currentlyVisible2.set(index$iv, transition2.getTargetState());
                }
                contentMap.clear();
                SnapshotStateList $this$fastForEach$iv = currentlyVisible2;
                int $i$f$fastForEach = 0;
                int index$iv2 = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv2 < size) {
                    T t = $this$fastForEach$iv.get(index$iv2);
                    contentMap.set(t, ComposableLambdaKt.rememberComposableLambda(-1426421288, true, new CrossfadeKt$Crossfade$5$1(transition2, animationSpec, t, function32), $composer2, 54));
                    index$iv2++;
                    transition2 = transition;
                    $i$f$fastForEach = $i$f$fastForEach;
                    currentlyVisible2 = currentlyVisible2;
                    function32 = function3;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                }
                currentlyVisible = currentlyVisible2;
                $composer2.endReplaceGroup();
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier3);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3669boximpl(SkippableUpdater.m3670constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1517004430, "C:Crossfade.kt#xbi5r1");
            $composer2.startReplaceGroup(-187482432);
            ComposerKt.sourceInformation($composer2, "");
            SnapshotStateList $this$fastForEach$iv2 = currentlyVisible;
            int $i$f$fastForEach2 = $this$fastForEach$iv2.size();
            int index$iv3 = 0;
            while (index$iv3 < $i$f$fastForEach2) {
                Object item$iv = $this$fastForEach$iv2.get(index$iv3);
                List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                int i7 = $i$f$fastForEach2;
                int index$iv4 = index$iv3;
                $composer2.startMovableGroup(-1081873445, contentKey.invoke(item$iv));
                ComposerKt.sourceInformation($composer2, "");
                Function2 function2 = (Function2) contentMap.get(item$iv);
                if (function2 == null) {
                    $composer2.startReplaceGroup(821713034);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1081871785);
                    ComposerKt.sourceInformation($composer2, "140@5906L8");
                    function2.invoke($composer2, 0);
                    $composer2.endReplaceGroup();
                }
                $composer2.endMovableGroup();
                index$iv3 = index$iv4 + 1;
                $i$f$fastForEach2 = i7;
                $this$fastForEach$iv2 = $this$fastForEach$iv3;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            animationSpec2 = animationSpec;
            contentKey2 = contentKey;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) throws Throwable {
                    CrossfadeKt.Crossfade(transition, modifier4, animationSpec2, contentKey2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
