package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u009a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyHeadersEnabled", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;ZLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    public static final void LazyList(final Modifier modifier, LazyListState state, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, final FlingBehavior flingBehavior, final boolean userScrollEnabled, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Arrangement.Vertical verticalArrangement, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        PaddingValues paddingValues;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int beyondBoundsItemCount2;
        Object value$iv$iv;
        int $dirty;
        Composer $composer2;
        final Alignment.Horizontal horizontalAlignment2;
        final int $dirty2;
        final Alignment.Vertical verticalAlignment2;
        final Arrangement.Horizontal horizontalArrangement2;
        final Arrangement.Vertical verticalArrangement2;
        final LazyListState lazyListState = state;
        Composer $composer3 = $composer.startRestartGroup(620764179);
        ComposerKt.sourceInformation($composer3, "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)81@3859L50,83@3935L48,84@4009L24,85@4081L7,86@4150L7,88@4183L395,109@4816L278,117@5164L153,123@5480L7,116@5108L481,128@5650L317,105@4671L1429:LazyList.kt#428nma");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(lazyListState) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
            paddingValues = contentPadding;
        } else if (($changed & 384) == 0) {
            paddingValues = contentPadding;
            $dirty3 |= $composer3.changed(paddingValues) ? 256 : 128;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
            z = reverseLayout;
        } else if (($changed & 3072) == 0) {
            z = reverseLayout;
            $dirty3 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = reverseLayout;
        }
        if ((i & 16) != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changed(isVertical) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((196608 & $changed) == 0) {
            $dirty3 |= $composer3.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
            i2 = beyondBoundsItemCount;
        } else if (($changed & 12582912) == 0) {
            i2 = beyondBoundsItemCount;
            $dirty3 |= $composer3.changed(i2) ? 8388608 : 4194304;
        } else {
            i2 = beyondBoundsItemCount;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
            i3 = i8;
        } else if (($changed & 100663296) == 0) {
            i3 = i8;
            $dirty3 |= $composer3.changed(horizontalAlignment) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i8;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
            i4 = i9;
        } else if (($changed & 805306368) == 0) {
            i4 = i9;
            $dirty3 |= $composer3.changed(verticalArrangement) ? 536870912 : 268435456;
        } else {
            i4 = i9;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
            i5 = i10;
        } else if (($changed1 & 6) == 0) {
            i5 = i10;
            $dirty1 |= $composer3.changed(verticalAlignment) ? 4 : 2;
        } else {
            i5 = i10;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
            i6 = i11;
        } else if (($changed1 & 48) == 0) {
            i6 = i11;
            $dirty1 |= $composer3.changed(horizontalArrangement) ? 32 : 16;
        } else {
            i6 = i11;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            horizontalAlignment2 = horizontalAlignment;
            verticalArrangement2 = verticalArrangement;
            verticalAlignment2 = verticalAlignment;
            horizontalArrangement2 = horizontalArrangement;
            $dirty = $dirty3;
            $dirty2 = i2;
            $composer2 = $composer3;
        } else {
            int beyondBoundsItemCount3 = i7 != 0 ? 0 : i2;
            Alignment.Horizontal horizontalAlignment3 = i3 != 0 ? null : horizontalAlignment;
            Arrangement.Vertical verticalArrangement3 = i4 != 0 ? null : verticalArrangement;
            Alignment.Vertical verticalAlignment3 = i5 != 0 ? null : verticalAlignment;
            Arrangement.Horizontal horizontalArrangement3 = i6 != 0 ? null : horizontalArrangement;
            if (ComposerKt.isTraceInProgress()) {
                beyondBoundsItemCount2 = beyondBoundsItemCount3;
                ComposerKt.traceEventStart(620764179, $dirty3, $dirty12, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
            } else {
                beyondBoundsItemCount2 = beyondBoundsItemCount3;
            }
            Function0 itemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, $composer3, (($dirty3 >> 3) & 14) | (($dirty12 >> 3) & 112));
            LazyLayoutSemanticState semanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, isVertical, $composer3, (($dirty3 >> 3) & 14) | (($dirty3 >> 9) & 112));
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
            CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<GraphicsContext> localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localGraphicsContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            GraphicsContext graphicsContext = (GraphicsContext) objConsume;
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalScrollCaptureInProgress();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean stickyHeadersEnabled = !((Boolean) objConsume2).booleanValue();
            int i12 = ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | (($dirty3 >> 6) & 458752) | (($dirty3 >> 6) & 3670016) | (($dirty12 << 21) & 29360128) | (($dirty12 << 21) & 234881024) | (1879048192 & $dirty3);
            Arrangement.Horizontal horizontalArrangement4 = horizontalArrangement3;
            int beyondBoundsItemCount4 = beyondBoundsItemCount2;
            int beyondBoundsItemCount5 = $dirty3;
            Alignment.Horizontal horizontalAlignment4 = horizontalAlignment3;
            boolean z2 = z;
            Arrangement.Vertical verticalArrangement4 = verticalArrangement3;
            Alignment.Vertical verticalAlignment4 = verticalAlignment3;
            Function2 measurePolicy = rememberLazyListMeasurePolicy(itemProviderLambda, state, paddingValues, z2, isVertical, beyondBoundsItemCount4, horizontalAlignment4, verticalAlignment4, horizontalArrangement4, verticalArrangement4, coroutineScope, graphicsContext, stickyHeadersEnabled, $composer3, i12, 0);
            lazyListState = state;
            Orientation orientation = isVertical ? Orientation.Vertical : Orientation.Horizontal;
            Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), itemProviderLambda, semanticState, orientation, userScrollEnabled, reverseLayout, $composer3, ((beyondBoundsItemCount5 >> 6) & 57344) | ((beyondBoundsItemCount5 << 6) & 458752));
            LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, beyondBoundsItemCount4, $composer3, ((beyondBoundsItemCount5 >> 3) & 14) | ((beyondBoundsItemCount5 >> 18) & 112));
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo = lazyListState.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $dirty = beyondBoundsItemCount5;
            LazyLayoutKt.LazyLayout((Function0<? extends LazyLayoutItemProvider>) itemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics, lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState, beyondBoundsInfo, reverseLayout, (LayoutDirection) objConsume3, orientation, userScrollEnabled, $composer3, (MutableVector.$stable << 6) | ($dirty & 7168) | (3670016 & $dirty)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation, userScrollEnabled, reverseLayout, flingBehavior, lazyListState.getInternalInteractionSource(), null, $composer3, ($dirty & 112) | (($dirty >> 9) & 7168) | (($dirty << 3) & 57344) | ($dirty & 458752), 64), lazyListState.getPrefetchState(), (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) measurePolicy, $composer3, 0, 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontalAlignment2 = horizontalAlignment4;
            $dirty2 = beyondBoundsItemCount4;
            verticalAlignment2 = verticalAlignment4;
            horizontalArrangement2 = horizontalArrangement4;
            verticalArrangement2 = verticalArrangement4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.1
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

                public final void invoke(Composer composer, int i13) {
                    LazyListKt.LazyList(modifier, lazyListState, contentPadding, reverseLayout, isVertical, flingBehavior, userScrollEnabled, $dirty2, horizontalAlignment2, verticalArrangement2, verticalAlignment2, horizontalArrangement2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[PHI: r8
      0x0038: PHI (r8v3 androidx.compose.foundation.lazy.LazyListState) = (r8v1 androidx.compose.foundation.lazy.LazyListState), (r8v4 androidx.compose.foundation.lazy.LazyListState) binds: [B:12:0x0036, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[PHI: r10
      0x0052: PHI (r10v3 androidx.compose.foundation.layout.PaddingValues) = (r10v1 androidx.compose.foundation.layout.PaddingValues), (r10v4 androidx.compose.foundation.layout.PaddingValues) binds: [B:22:0x0050, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[PHI: r11
      0x006d: PHI (r11v3 boolean) = (r11v1 boolean), (r11v4 boolean) binds: [B:32:0x006b, B:28:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[PHI: r4
      0x008a: PHI (r4v22 boolean) = (r4v18 boolean), (r4v23 boolean) binds: [B:42:0x0088, B:38:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6 A[PHI: r9
      0x00a6: PHI (r9v11 androidx.compose.ui.Alignment$Horizontal) = (r9v8 androidx.compose.ui.Alignment$Horizontal), (r9v12 androidx.compose.ui.Alignment$Horizontal) binds: [B:52:0x00a4, B:48:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2 A[PHI: r12
      0x00c2: PHI (r12v12 androidx.compose.ui.Alignment$Vertical) = (r12v9 androidx.compose.ui.Alignment$Vertical), (r12v13 androidx.compose.ui.Alignment$Vertical) binds: [B:62:0x00c0, B:58:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de A[PHI: r13
      0x00de: PHI (r13v12 androidx.compose.foundation.layout.Arrangement$Horizontal) = 
      (r13v9 androidx.compose.foundation.layout.Arrangement$Horizontal)
      (r13v13 androidx.compose.foundation.layout.Arrangement$Horizontal)
     binds: [B:72:0x00dc, B:68:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fa A[PHI: r14
      0x00fa: PHI (r14v12 androidx.compose.foundation.layout.Arrangement$Vertical) = 
      (r14v9 androidx.compose.foundation.layout.Arrangement$Vertical)
      (r14v13 androidx.compose.foundation.layout.Arrangement$Vertical)
     binds: [B:82:0x00f8, B:78:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a A[PHI: r15
      0x011a: PHI (r15v9 boolean) = (r15v7 boolean), (r15v10 boolean) binds: [B:92:0x0118, B:88:0x0111] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> rememberLazyListMeasurePolicy(final kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.LazyListItemProvider> r23, androidx.compose.foundation.lazy.LazyListState r24, androidx.compose.foundation.layout.PaddingValues r25, boolean r26, boolean r27, final int r28, androidx.compose.ui.Alignment.Horizontal r29, androidx.compose.ui.Alignment.Vertical r30, androidx.compose.foundation.layout.Arrangement.Horizontal r31, androidx.compose.foundation.layout.Arrangement.Vertical r32, final kotlinx.coroutines.CoroutineScope r33, final androidx.compose.ui.graphics.GraphicsContext r34, boolean r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.rememberLazyListMeasurePolicy(kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext, boolean, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
