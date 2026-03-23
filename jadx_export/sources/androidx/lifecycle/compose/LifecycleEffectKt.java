package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: LifecycleEffect.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010\f\u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u001f\u001a0\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010 \u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u008a\u0084\u0002"}, d2 = {"LifecycleResumeEffectNoParamError", "", "LifecycleStartEffectNoParamError", "LifecycleEventEffect", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffect", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key1", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleStartEffect", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LifecycleEffectKt {
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleEventEffect(final androidx.lifecycle.Lifecycle.Event r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function0<kotlin.Unit> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleStartEffect(final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LifecycleStartEffect(final Object key1, final Object key2, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        final LifecycleOwner lifecycleOwner2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(696924721);
        ComposerKt.sourceInformation($composer2, "C(LifecycleStartEffect)P(1,2,3)196@8866L7,199@9003L108,202@9116L80:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key1) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 256 : 128;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
            } else if ((i & 4) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -897;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(696924721, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:198)");
            }
            $composer2.startReplaceableGroup(-1877873222);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key1) | $composer2.changed(key2) | $composer2.changed(lifecycleOwner2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) value$iv;
            $composer2.endReplaceableGroup();
            LifecycleStartEffectImpl(lifecycleOwner2, lifecycleStartStopEffectScope, function1, $composer2, (($dirty >> 6) & 14) | (($dirty >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.2
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
                    LifecycleEffectKt.LifecycleStartEffect(key1, key2, lifecycleOwner2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object key1, final Object key2, final Object key3, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        LifecycleOwner lifecycleOwner2;
        Object value$iv;
        final LifecycleOwner lifecycleOwner3;
        Composer $composer2 = $composer.startRestartGroup(574812561);
        ComposerKt.sourceInformation($composer2, "C(LifecycleStartEffect)P(1,2,3,4)261@12007L7,264@12144L114,267@12263L80:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key1) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(key3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
            } else if ((i & 8) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -7169;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574812561, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:263)");
            }
            $composer2.startReplaceableGroup(-1877772704);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key1) | $composer2.changed(key2) | $composer2.changed(key3) | $composer2.changed(lifecycleOwner2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) value$iv;
            $composer2.endReplaceableGroup();
            LifecycleStartEffectImpl(lifecycleOwner2, lifecycleStartStopEffectScope, function1, $composer2, (($dirty >> 9) & 14) | (($dirty >> 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            lifecycleOwner3 = lifecycleOwner2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.3
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
                    LifecycleEffectKt.LifecycleStartEffect(key1, key2, key3, lifecycleOwner3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LifecycleStartEffect(final Object[] keys, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        LifecycleOwner lifecycleOwner2;
        Object value$iv$iv;
        final LifecycleOwner lifecycleOwner3;
        Composer $composer2 = $composer.startRestartGroup(-1510305724);
        ComposerKt.sourceInformation($composer2, "C(LifecycleStartEffect)P(1,2)325@15110L103,328@15218L80:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 32 : 16;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        $composer2.startMovableGroup(-1877684705, Integer.valueOf(keys.length));
        ComposerKt.sourceInformation($composer2, "322@14973L7");
        for (Object value : keys) {
            $dirty |= $composer2.changedInstance(value) ? 4 : 0;
        }
        $composer2.endMovableGroup();
        if (($dirty & 14) == 0) {
            $dirty |= 2;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
            } else if ((i & 2) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -113;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1510305724, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:324)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(keys);
            spreadBuilder.add(lifecycleOwner2);
            Object[] keys$iv = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) value$iv$iv;
            LifecycleStartEffectImpl(lifecycleOwner2, lifecycleStartStopEffectScope, function1, $composer2, (($dirty >> 3) & 14) | ($dirty & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            lifecycleOwner3 = lifecycleOwner2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.4
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
                    LifecycleEffectKt.LifecycleStartEffect(Arrays.copyOf(keys, keys.length), lifecycleOwner3, (Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleStartEffectNoParamError)
    public static final void LifecycleStartEffect(final LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-50807951);
        ComposerKt.sourceInformation($composer2, "C(LifecycleStartEffect)P(1)348@16079L7:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($dirty & 1) == 0 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.5
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

                    public final void invoke(Composer composer, int i2) {
                        LifecycleEffectKt.LifecycleStartEffect(lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
                return;
            }
            return;
        }
        $composer2.startDefaults();
        if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
            if ((i & 1) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $dirty &= -15;
            }
        } else {
            $composer2.skipToGroupEnd();
            if ((i & 1) != 0) {
                $dirty &= -15;
            }
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-50807951, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:350)");
        }
        throw new IllegalStateException(LifecycleStartEffectNoParamError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleStartEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope scope, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer $composer, final int $changed) {
        LifecycleEffectKt$LifecycleStartEffectImpl$1$1 value$iv;
        Composer $composer2 = $composer.startRestartGroup(228371534);
        ComposerKt.sourceInformation($composer2, "C(LifecycleStartEffectImpl)P(1,2)358@16483L619,358@16443L659:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(lifecycleOwner) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, $dirty, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:357)");
            }
            $composer2.startReplaceableGroup(-1076218375);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty & 896) == 256) | $composer2.changedInstance(lifecycleOwner);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleEffectKt$LifecycleStartEffectImpl$1$1(lifecycleOwner, scope, function1);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, scope, (Function1) value$iv, $composer2, ($dirty & 14) | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffectImpl.2
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

                public final void invoke(Composer composer, int i) {
                    LifecycleEffectKt.LifecycleStartEffectImpl(lifecycleOwner, scope, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LifecycleResumeEffect(final Object key1, final Object key2, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        final LifecycleOwner lifecycleOwner2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(752680142);
        ComposerKt.sourceInformation($composer2, "C(LifecycleResumeEffect)P(1,2,3)529@24201L7,532@24343L110,535@24458L83:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key1) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 256 : 128;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
            } else if ((i & 4) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -897;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(752680142, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:531)");
            }
            $composer2.startReplaceableGroup(1470097201);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key1) | $composer2.changed(key2) | $composer2.changed(lifecycleOwner2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope = (LifecycleResumePauseEffectScope) value$iv;
            $composer2.endReplaceableGroup();
            LifecycleResumeEffectImpl(lifecycleOwner2, lifecycleResumePauseEffectScope, function1, $composer2, (($dirty >> 6) & 14) | (($dirty >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.2
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
                    LifecycleEffectKt.LifecycleResumeEffect(key1, key2, lifecycleOwner2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LifecycleResumeEffect(final Object key1, final Object key2, final Object key3, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        LifecycleOwner lifecycleOwner2;
        Object value$iv;
        final LifecycleOwner lifecycleOwner3;
        Composer $composer2 = $composer.startRestartGroup(-485941842);
        ComposerKt.sourceInformation($composer2, "C(LifecycleResumeEffect)P(1,2,3,4)594@27382L7,597@27524L116,600@27645L83:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key1) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(key3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
            } else if ((i & 8) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -7169;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-485941842, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:596)");
            }
            $composer2.startReplaceableGroup(1470198999);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key1) | $composer2.changed(key2) | $composer2.changed(key3) | $composer2.changed(lifecycleOwner2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope = (LifecycleResumePauseEffectScope) value$iv;
            $composer2.endReplaceableGroup();
            LifecycleResumeEffectImpl(lifecycleOwner2, lifecycleResumePauseEffectScope, function1, $composer2, (($dirty >> 9) & 14) | (($dirty >> 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            lifecycleOwner3 = lifecycleOwner2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.3
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
                    LifecycleEffectKt.LifecycleResumeEffect(key1, key2, key3, lifecycleOwner3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LifecycleResumeEffect(final Object[] keys, LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        LifecycleOwner lifecycleOwner2;
        Object value$iv$iv;
        final LifecycleOwner lifecycleOwner3;
        Composer $composer2 = $composer.startRestartGroup(-781756895);
        ComposerKt.sourceInformation($composer2, "C(LifecycleResumeEffect)P(1,2)658@30536L105,661@30646L83:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                lifecycleOwner2 = lifecycleOwner;
                int i2 = $composer2.changedInstance(lifecycleOwner2) ? 32 : 16;
                $dirty |= i2;
            } else {
                lifecycleOwner2 = lifecycleOwner;
            }
            $dirty |= i2;
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        $composer2.startMovableGroup(1470288308, Integer.valueOf(keys.length));
        ComposerKt.sourceInformation($composer2, "655@30394L7");
        for (Object value : keys) {
            $dirty |= $composer2.changedInstance(value) ? 4 : 0;
        }
        $composer2.endMovableGroup();
        if (($dirty & 14) == 0) {
            $dirty |= 2;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
            } else if ((i & 2) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) objConsume;
                $dirty &= -113;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-781756895, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:657)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(keys);
            spreadBuilder.add(lifecycleOwner2);
            Object[] keys$iv = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycleRegistry());
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope = (LifecycleResumePauseEffectScope) value$iv$iv;
            LifecycleResumeEffectImpl(lifecycleOwner2, lifecycleResumePauseEffectScope, function1, $composer2, (($dirty >> 3) & 14) | ($dirty & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            lifecycleOwner3 = lifecycleOwner2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.4
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
                    LifecycleEffectKt.LifecycleResumeEffect(Arrays.copyOf(keys, keys.length), lifecycleOwner3, (Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleResumeEffectNoParamError)
    public static final void LifecycleResumeEffect(final LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-747476210);
        ComposerKt.sourceInformation($composer2, "C(LifecycleResumeEffect)P(1)681@31516L7:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($dirty & 1) == 0 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.5
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

                    public final void invoke(Composer composer, int i2) {
                        LifecycleEffectKt.LifecycleResumeEffect(lifecycleOwner, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
                return;
            }
            return;
        }
        $composer2.startDefaults();
        if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
            if ((i & 1) != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $dirty &= -15;
            }
        } else {
            $composer2.skipToGroupEnd();
            if ((i & 1) != 0) {
                $dirty &= -15;
            }
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-747476210, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:683)");
        }
        throw new IllegalStateException(LifecycleResumeEffectNoParamError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleResumeEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope scope, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer $composer, final int $changed) {
        LifecycleEffectKt$LifecycleResumeEffectImpl$1$1 value$iv;
        Composer $composer2 = $composer.startRestartGroup(912823238);
        ComposerKt.sourceInformation($composer2, "C(LifecycleResumeEffectImpl)P(1,2)691@31930L628,691@31890L668:LifecycleEffect.kt#2vxrgp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(lifecycleOwner) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, $dirty, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:690)");
            }
            $composer2.startReplaceableGroup(657406551);
            ComposerKt.sourceInformation($composer2, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty & 896) == 256) | $composer2.changedInstance(lifecycleOwner);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleEffectKt$LifecycleResumeEffectImpl$1$1(lifecycleOwner, scope, function1);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, scope, (Function1) value$iv, $composer2, ($dirty & 14) | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffectImpl.2
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

                public final void invoke(Composer composer, int i) {
                    LifecycleEffectKt.LifecycleResumeEffectImpl(lifecycleOwner, scope, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
